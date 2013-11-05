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
package org.apache.cloudstack.spring.module.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.cloudstack.spring.module.factory.CloudStackSpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

public class CloudStackContextLoaderListener extends ContextLoaderListener {

    public static final String WEB_PARENT_MODULE = "parentModule";
    public static final String WEB_PARENT_MODULE_DEFAULT = "web";

    private static final Logger log = LoggerFactory.getLogger(CloudStackContextLoaderListener.class);

    CloudStackSpringContext cloudStackContext;
    String configuredParentName;

    @Override
    protected ApplicationContext loadParentContext(ServletContext servletContext) {
        return cloudStackContext.getApplicationContextForWeb(configuredParentName);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        long start = System.currentTimeMillis();

        try {
            cloudStackContext = new CloudStackSpringContext();
            event.getServletContext().setAttribute(CloudStackSpringContext.CLOUDSTACK_CONTEXT_SERVLET_KEY, cloudStackContext);
        } catch (IOException e) {
            log.error("Failed to start CloudStack", e);
            throw new RuntimeException("Failed to initialize CloudStack Spring modules", e);
        }

        configuredParentName = event.getServletContext().getInitParameter(WEB_PARENT_MODULE);
        if ( configuredParentName == null ) {
            configuredParentName = WEB_PARENT_MODULE_DEFAULT;
        }

        super.contextInitialized(event);

        log.info("Context Startup Done [{}] ms", (System.currentTimeMillis() - start));
    }

    @Override
    protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext applicationContext) {
        super.customizeContext(servletContext, applicationContext);

        String[] newLocations = cloudStackContext.getConfigLocationsForWeb(configuredParentName,
                applicationContext.getConfigLocations());

        applicationContext.setConfigLocations(newLocations);
    }

}
