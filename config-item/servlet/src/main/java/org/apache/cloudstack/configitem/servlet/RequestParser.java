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

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cloudstack.configitem.model.DefaultItemVersion;
import org.apache.cloudstack.configitem.model.impl.DefaultClient;

import com.cloud.vm.SystemVm;

public class RequestParser {

    private static final Pattern REQUEST_PATTERN = Pattern.compile("/config/([-a-z0-9]+)");

    public ServletConfigRequest parse(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath();

        Matcher m = REQUEST_PATTERN.matcher(path.toLowerCase());
        if ( ! m.matches() )
            return null;

        String item = m.group(1);

        /* This is a hack */
        String systemVm = request.getParameter("vm");
        String applied = request.getParameter("applied");
        Long systemVmId = null;

        try {
            if ( systemVm == null )
                return null;
            systemVmId = new Long(systemVm);
        } catch ( NumberFormatException nfe ) {
            return null;
        }

        return new ServletConfigRequest(response, item, new DefaultClient(SystemVm.class, systemVmId), 
                DefaultItemVersion.fromString(applied), getParameters(request));
    }
    
    @SuppressWarnings("unchecked")
    protected Map<String,String[]> getParameters(HttpServletRequest request) {
        return (Map<String,String[]>)request.getParameterMap();
    }
}
