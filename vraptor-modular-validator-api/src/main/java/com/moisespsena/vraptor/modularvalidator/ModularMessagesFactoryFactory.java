/***
 * Copyright (c) 2011 Moises P. Sena - www.moisespsena.com
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.moisespsena.vraptor.modularvalidator;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

/**
 * @author elipse
 * 
 */
@Component
@ApplicationScoped
public class ModularMessagesFactoryFactory implements
		ComponentFactory<ModularMessagesFactory> {
	private static final Logger logger = LoggerFactory
			.getLogger(ModularMessagesFactoryFactory.class);
	private ModularMessagesFactory modularMessagesFactory;
	private final Proxifier proxifier;

	public ModularMessagesFactoryFactory(final Proxifier proxifier) {
		this.proxifier = proxifier;
		if (logger.isDebugEnabled()) {
			logger.debug("Initializing default ModularMessagesFactory");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.vraptor.ioc.ComponentFactory#getInstance()
	 */
	@Override
	public ModularMessagesFactory getInstance() {
		if (modularMessagesFactory == null) {
			modularMessagesFactory = proxifier.proxify(
					ModularMessagesFactory.class,
					new MethodInvocation<ModularMessagesFactory>() {
						@Override
						public Object intercept(
								final ModularMessagesFactory proxy,
								final Method method, final Object[] args,
								final SuperMethod superMethod) {
							throw new UnimplementedBeanException(
									ModularMessagesFactory.class);
						}
					});
		}

		return modularMessagesFactory;
	}

}
