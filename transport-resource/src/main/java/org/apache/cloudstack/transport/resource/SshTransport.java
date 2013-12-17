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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.agent.api.Answer;
import com.cloud.agent.api.Command;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SshTransport implements Transport {

    private static final Logger log = LoggerFactory.getLogger(SshTransport.class);

    String hostname, username, password;
    int port;
    Session session;
    Channel channel;
    boolean connected = false;

    public SshTransport(String hostname, String username, String password, int port) {
        super();
        this.hostname = hostname;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public synchronized void connect() throws IOException {
        if ( connected ) {
            return;
        }

        try {
            log.error("Connecting to SSH [{}@{}:{}]", username, hostname, port);
            session = new JSch().getSession(username, hostname, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = session.openChannel("shell");
            channel.connect();
            connected = true;
        } catch (JSchException e) {
            log.error("Failed to connect to SSH [{}@{}:{}]", username, hostname, port);
            throw new IOException(e);
        }
    }

    @Override
    public Answer executeRequest(Command cmd) {
        try {
            connect();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to connect", e);
        }
        return null;
    }

    @Override
    public synchronized void disconnect() {
        if ( connected ) {
            log.error("Closing SSH connection to [{}@{}:{}]", username, hostname, port);
            connected = false;
            if ( channel != null ) {
                channel.disconnect();
            }
            if ( session != null ) {
                session.disconnect();
            }
        }
    }

}
