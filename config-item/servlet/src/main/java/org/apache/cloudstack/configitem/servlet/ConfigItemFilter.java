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
package org.apache.cloudstack.configitem.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cloudstack.configitem.server.service.ConfigItemServer;
import org.apache.cloudstack.spring.module.web.ModuleBasedFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigItemFilter extends ModuleBasedFilter {

    private static final Logger log = LoggerFactory.getLogger(ConfigItemFilter.class);

    RequestParser requestParser = new RequestParser();
    ConfigItemServer itemServer;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        ServletConfigRequest configRequest = null;
        try {
            if ( isEnabled() && request instanceof HttpServletRequest && response instanceof HttpServletResponse ) {
                configRequest = requestParser.parse((HttpServletRequest)request, (HttpServletResponse)response);
                if ( configRequest != null ) {
                    log.info("Handling Config Item Request : {}", configRequest);
                    itemServer.handleRequest(configRequest);
                }
            }

            if ( configRequest == null ) {
                chain.doFilter(request, response);
            }
        } catch ( IOException e ) {
            log.error("Failed to run config item request [{}]", configRequest, e);
            throw e;
        } finally {
            if ( configRequest != null ) {
                configRequest.close();
            }
        }
    }

    @Override
    public void destroy() {
    }

    public RequestParser getRequestParser() {
        return requestParser;
    }

    public void setRequestParser(RequestParser requestParser) {
        this.requestParser = requestParser;
    }

    public ConfigItemServer getItemServer() {
        return itemServer;
    }

    @Inject
    public void setItemServer(ConfigItemServer itemServer) {
        this.itemServer = itemServer;
    }

}
