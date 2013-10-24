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
package org.apache.cloudstack.network.generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

import javax.inject.Inject;

import org.apache.cloudstack.network.generic.impl.DefaultGenericNetworkElementDelegate;

import com.cloud.network.element.NetworkElement;

public class GenericNetworkElementInvocationHandler implements InvocationHandler {

    NetworkElement networkElement;
    GenericNetworkElementDelegate delegate = new DefaultGenericNetworkElementDelegate();
    Set<String> networkElementMethods;

    public GenericNetworkElementInvocationHandler(NetworkElement networkElement, Set<String> networkElementMethods) {
        super();
        this.networkElement = networkElement;
        this.networkElementMethods = networkElementMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (networkElementMethods.contains(method.getName()))
            return method.invoke(networkElement, args);

        delegate.invoke(method.getName(), args);

        if ( method.getReturnType() == Boolean.TYPE )
            return true;

        return null;
    }

    public GenericNetworkElementDelegate getDelegate() {
        return delegate;
    }

    @Inject
    public void setDelegate(GenericNetworkElementDelegate delegate) {
        this.delegate = delegate;
    }

}
