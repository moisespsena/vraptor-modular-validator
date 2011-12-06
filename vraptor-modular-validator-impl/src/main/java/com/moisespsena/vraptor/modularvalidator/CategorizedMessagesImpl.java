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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import br.com.caelum.vraptor.validator.Message;

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 02/09/2011
 */
public class CategorizedMessagesImpl implements CategorizedMessages {
	private static final long serialVersionUID = -8537135839997923181L;

	private static SimpleMessage[] createMessages(final Message[] messages) {
		final SimpleMessage[] simpleMessages = new SimpleMessage[messages.length];

		int i = 0;
		for (final Message message : messages) {
			simpleMessages[i++] = new SimpleMessageImpl(message.getCategory(),
					message.getMessage(), MessagesLevel.ERROR);
		}

		return simpleMessages;
	}

	private Category[] categories;

	public CategorizedMessagesImpl() {

	}

	public CategorizedMessagesImpl(final Collection<SimpleMessage> messages) {
		this(messages.toArray(new SimpleMessage[0]));
	}

	public CategorizedMessagesImpl(final Message[] messages) {
		this(createMessages(messages));
	}

	/**
	 * 
	 */
	public CategorizedMessagesImpl(final SimpleMessage[] messages) {
		final Map<String, List<SimpleMessage>> map = new HashMap<String, List<SimpleMessage>>();

		for (final SimpleMessage message : messages) {
			final String categoryName = message.getCategory();
			List<SimpleMessage> messages2 = map.get(categoryName);
			if (messages2 == null) {
				messages2 = new ArrayList<SimpleMessage>();
				map.put(categoryName, messages2);
			}

			messages2.add(message);
		}

		this.categories = new Category[map.size()];

		int i = 0;
		for (final String categoryName : map.keySet()) {
			this.categories[i++] = new CategoryImpl(categoryName, map.get(
					categoryName).toArray(new SimpleMessage[0]));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moisespsena.vraptor.modularvalidator.CategorizedMessages#getCategories
	 * ()
	 */
	@Override
	public Category[] getCategories() {
		return categories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moisespsena.vraptor.modularvalidator.Messages#getMessages()
	 */
	@Override
	public SimpleMessage[] getMessages() {
		final List<SimpleMessage> messages = new ArrayList<SimpleMessage>();
		for (final Category category : categories) {
			for (final SimpleMessage message : category.getMessages()) {
				messages.add(message);
			}
		}

		final SimpleMessage[] arr = messages.toArray(new SimpleMessage[0]);
		return arr;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(final Category[] categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("categories", categories)
				.toString();
	}

}
