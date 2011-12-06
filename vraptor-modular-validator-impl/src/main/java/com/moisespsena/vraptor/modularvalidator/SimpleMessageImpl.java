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
 * @since 1.0 05/08/2011
 * 
 */
public class SimpleMessageImpl implements SimpleMessage {
	private static final long serialVersionUID = -6528010808386684358L;
	private String category;
	private String level;
	private String message;

	/**
	 * 
	 */
	public SimpleMessageImpl() {
	}

	public SimpleMessageImpl(final String category, final String message,
			final String level) {
		super();
		this.category = category;
		this.message = message;
		this.level = level;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public String getLevel() {
		return level;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setCategory(final String category) {
		this.category = category;
	}

	@Override
	public void setLevel(final String level) {
		this.level = level;
	}

	@Override
	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("category", category)
				.append("messages", message).toString();
	}
}
