/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cloudstack.transport.resource;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.agent.api.Answer;
import com.cloud.agent.api.Command;
import com.cloud.agent.api.PingCommand;
import com.cloud.agent.api.ReadyAnswer;
import com.cloud.agent.api.ReadyCommand;
import com.cloud.host.Host.Type;
import com.cloud.resource.ServerResource;

public class TransportResource extends AbstractRoutingResource implements ServerResource {

    private static final Logger log = LoggerFactory.getLogger(TransportResource.class);
    
    Transport transport;

    public TransportResource(Transport transport) {
        this.transport = transport;
    }

    @Override
    public PingCommand getCurrentStatus(long id) {
        return new PingCommand(Type.Routing, id);
    }

    @Override
    public Answer executeRequest(Command cmd) {
        try {
            return (Answer)MethodUtils.invokeExactMethod(this, "executeRequest", cmd);
        } catch (NoSuchMethodException e) {
            return transport.executeRequest(cmd);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public Answer executeRequest(ReadyCommand cmd) {
        return new ReadyAnswer(cmd);
    }

    @Override
    public void disconnected() {
    }

    @Override
    public boolean start() {
        try {
            transport.connect();
        } catch (IOException e) {
            log.error("Failed to connect to transport", e);
            return false;
        }

        return true;
    }

    @Override
    public boolean stop() {
        transport.disconnect();
        return true;
    }

}
