// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.async;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.naming.ConfigurationException;

import org.apache.cloudstack.framework.messagebus.MessageBus;
import org.apache.cloudstack.framework.messagebus.MessageDispatcher;
import org.apache.cloudstack.framework.messagebus.MessageHandler;
import org.apache.cloudstack.messagebus.TopicConstants;
import org.apache.log4j.Logger;

import com.cloud.utils.component.ManagerBase;

public class AsyncJobMonitor extends ManagerBase {
    public static final Logger s_logger = Logger.getLogger(AsyncJobMonitor.class);
    
    @Inject private MessageBus _messageBus;
	
	private Map<Long, ActiveTaskRecord> _activeTasks = new HashMap<Long, ActiveTaskRecord>();
	private Timer _timer = new Timer();
	
	private volatile int _activePoolThreads = 0;
	private volatile int _activeInplaceThreads = 0;
	
	// configuration
	private long _inactivityCheckIntervalMs = 60000;
	private long _inactivityWarningThresholdMs = 90000;
	
	public AsyncJobMonitor() {
	}
	
	public long getInactivityCheckIntervalMs() {
		return _inactivityCheckIntervalMs;
	}
	
	public void setInactivityCheckIntervalMs(long intervalMs) {
		_inactivityCheckIntervalMs = intervalMs;
	}
	
	public long getInactivityWarningThresholdMs() {
		return _inactivityWarningThresholdMs;
	}
	
	public void setInactivityWarningThresholdMs(long thresholdMs) {
		_inactivityWarningThresholdMs = thresholdMs;
	}
	
	@MessageHandler(topic=TopicConstants.JOB_HEARTBEAT)
	public void onJobHeartbeatNotify(String subject, String senderAddress, Object args) {
		if(args != null && args instanceof Long) {
			synchronized(this) {
				ActiveTaskRecord record = _activeTasks.get((Long)args);
				if(record != null) {
					record.updateJobHeartbeatTick();
				}
			}
		}
	}
	
	private void heartbeat() {
		synchronized(this) {
			for(Map.Entry<Long, ActiveTaskRecord> entry : _activeTasks.entrySet()) {
				if(entry.getValue().millisSinceLastJobHeartbeat() > _inactivityWarningThresholdMs) {
					s_logger.warn("Task (job-" + entry.getValue().getJobId() + ") has been pending for " 
						+ entry.getValue().millisSinceLastJobHeartbeat()/1000 + " seconds");
				}
			}
		}
	}
	
	@Override
	public boolean configure(String name, Map<String, Object> params)
			throws ConfigurationException {
		
		_messageBus.subscribe(TopicConstants.JOB_HEARTBEAT, MessageDispatcher.getDispatcher(this));
		_timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				heartbeat();
			}
			
		}, _inactivityCheckIntervalMs, _inactivityCheckIntervalMs);
		return true;
	}
	
	public void registerActiveTask(long jobId) {
		synchronized(this) {
			assert(_activeTasks.get(jobId) == null);
			
			long threadId = Thread.currentThread().getId();
			boolean fromPoolThread = Thread.currentThread().getName().contains(AsyncJobConstants.JOB_POOL_THREAD_PREFIX);
			ActiveTaskRecord record = new ActiveTaskRecord(threadId, jobId, fromPoolThread);
			_activeTasks.put(jobId, record);
			if(fromPoolThread)
				_activePoolThreads++;
			else
				_activeInplaceThreads++;
		}
	}
	
	public void unregisterActiveTask(long jobId) {
		synchronized(this) {
			ActiveTaskRecord record = _activeTasks.get(jobId);
			assert(record != null);
			if(record != null) {
				if(record.isPoolThread())
					_activePoolThreads--;
				else
					_activeInplaceThreads--;
				
				_activeTasks.remove(jobId);
			}
		}
	}
	
	public int getActivePoolThreads() {
		return _activePoolThreads;
	}
	
	public int getActiveInplaceThread() {
		return _activeInplaceThreads;
	}
	
	private static class ActiveTaskRecord {
		long _jobId;
		long _threadId;
		boolean _fromPoolThread;
		long _jobLastHeartbeatTick;
		
		public ActiveTaskRecord(long jobId, long threadId, boolean fromPoolThread) {
			_threadId = threadId;
			_jobId = jobId;
			_fromPoolThread = fromPoolThread;
			_jobLastHeartbeatTick = System.currentTimeMillis();
		}
		
		public long getThreadId() {
			return _threadId;
		}
		
		public long getJobId() {
			return _jobId;
		}
		
		public boolean isPoolThread() {
			return _fromPoolThread;
		}
		
		public void updateJobHeartbeatTick() {
			_jobLastHeartbeatTick = System.currentTimeMillis();
		}
		
		public long millisSinceLastJobHeartbeat() {
			return System.currentTimeMillis() - _jobLastHeartbeatTick;
		}
	}
}
