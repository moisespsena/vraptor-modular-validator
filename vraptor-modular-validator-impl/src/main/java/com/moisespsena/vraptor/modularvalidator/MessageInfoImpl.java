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

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 04/08/2011
 * 
 */
public class MessageInfoImpl implements MessageInfo {
	private String category = "default";
	private String key;
	private Object[] parameters = new Object[0];

	public MessageInfoImpl(final String key, final Object... paremeters) {
		this.key = key;
		this.parameters = paremeters;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Object[] getParameters() {
		return parameters;
	}

	public MessageInfoImpl setCategory(final String category) {
		this.category = category;
		return this;
	}

	public MessageInfoImpl setKey(final String key) {
		this.key = key;
		return this;
	}

	public MessageInfoImpl setParameters(final Object[] parameters) {
		this.parameters = parameters;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("key", key)
				.append("category", category).append("parameters", parameters)
				.toString();
	}
}
