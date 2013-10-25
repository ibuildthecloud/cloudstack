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
package org.apache.cloudstack.network.generic.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.cloudstack.network.generic.GenericNetworkElementFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ProviderParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id = element.getAttribute("id");
        
        BeanDefinitionBuilder factoryBuilder = BeanDefinitionBuilder.rootBeanDefinition(GenericNetworkElementFactory.class);
        factoryBuilder.addPropertyValue("providerName", id);

        Element handle = DomUtils.getChildElementByTagName(element, "handle");
        if ( handle != null ) {
            NamedNodeMap attrs = handle.getAttributes();
            for ( int i = 0 ; i < attrs.getLength() ; i++ ) {
                Node node = attrs.item(i);
                String name = node.getNodeName();
                String value = node.getNodeValue();

                factoryBuilder.addPropertyValue("handle" + StringUtils.capitalize(name), value);
            }
        }
        
        Map<String, Map<String, String>> services = new HashMap<String, Map<String,String>>();
        
        for ( Element service : DomUtils.getChildElementsByTagName(element, "service") ) {
            Map<String, String> capabilities = new HashMap<String, String>();
            services.put(service.getAttribute("name"), capabilities);
            
            for ( Element caps : DomUtils.getChildElementsByTagName(service, "capability") ) {
                capabilities.put(caps.getAttribute("name"), caps.getAttribute("value"));
            }
        }
        
        factoryBuilder.addPropertyValue("services", services);
        
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        builder.getRawBeanDefinition().setFactoryBeanName(id + "$factory");
        builder.getRawBeanDefinition().setFactoryMethodName("buildNetworkElement");

        /* You might be thinking it's silly to use a factory and then a bean referring to the factory
         * and to not use a Spring FactoryBean.  There is actually a very good reason for it.  If you
         * use a Spring FactoryBean, it makes it very difficult to discover and register the extension
         * by the RegistryLifecycle class.
         */
        register(id, builder, parserContext);
        return register(id + "$factory", factoryBuilder, parserContext);
    }

    protected BeanDefinition register(String id, BeanDefinitionBuilder builder, ParserContext parserContext) {
        BeanDefinition def = builder.getBeanDefinition();
        BeanDefinitionHolder holder = new BeanDefinitionHolder(def, id);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, parserContext.getRegistry());

        return def;
    }

}
