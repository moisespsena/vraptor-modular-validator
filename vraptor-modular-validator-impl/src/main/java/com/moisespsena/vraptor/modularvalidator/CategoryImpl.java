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
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 02/09/2011
 */
public class CategoryImpl implements Category {
	private static final long serialVersionUID = -6129132918277666240L;
	private SimpleMessage[] messages;
	private String name;

	public CategoryImpl() {
		this(null, null);
	}

	public CategoryImpl(final String name) {
		this(name, null);
	}

	/**
	 * @param name Nome da categoria
	 * @param messages Mensagens
	 */
	public CategoryImpl(final String name, final SimpleMessage[] messages) {
		super();
		this.name = name;
		this.messages = messages;
	}

	@Override
	public SimpleMessage[] getMessages() {
		return messages;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setMessages(final SimpleMessage[] messages) {
		this.messages = messages;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name)
				.append("messsages", messages).toString();
	}
}
