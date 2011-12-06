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
package com.moisespsena.vraptor.modularvalidator;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.ResourceBundleDescription;

import br.com.caelum.vraptor.validator.Message;

public class ModularValidations {

	private final List<Message> errors = new ArrayList<Message>();
	private final ModularMessagesFactory modularMessagesFactory;

	public ModularValidations(
			final ModularMessagesFactory modularMessagesFactory) {
		this.modularMessagesFactory = modularMessagesFactory;
	}

	private void add(final Message message) {
		errors.add(message);
	}

	/**
	 * Adds a list of errors to the error list.
	 */
	public ModularValidations and(final List<Message> errors) {
		this.errors.addAll(errors);
		return this;
	}

	/**
	 * Adds a single error message to the error list.
	 */
	public ModularValidations and(final Message error) {
		this.errors.add(error);
		return this;
	}

	/**
	 * Returns the list of errors.
	 */
	public List<Message> getErrors() {
		return errors;
	}

	public boolean sequence(final Boolean... thats) {
		for (final boolean is : thats) {
			if (!is) {
				return false;
			}
		}
		return true;
	}

	public boolean that(final boolean assertion, final Message message) {
		if (!assertion) {
			add(message);
		}
		return assertion;
	}

	public boolean that(final boolean assertion, final MessageInfo messageInfo) {
		if (!assertion) {
			add(modularMessagesFactory.createI18n(messageInfo));
		}

		return assertion;
	}

	public boolean that(final boolean assertion, final String category,
			final String reason, final Object... messageParameters) {
		if (!assertion) {
			add(modularMessagesFactory.createI18n(category, reason,
					messageParameters));
		}
		return assertion;
	}

	public <T> boolean that(final T id, final Matcher<? super T> matcher) {
		return that(id, matcher, "", null);
	}

	public <T> boolean that(final T actual, final Matcher<? super T> matcher,
			final Message message) {
		if (!matcher.matches(actual)) {
			add(message);
			return false;
		}
		return true;
	}

	public <T> boolean that(final T id, final Matcher<? super T> matcher,
			final String category) {
		return that(id, matcher, category, null);
	}

	public <T> boolean that(final T actual, final Matcher<? super T> matcher,
			final String category, String reason,
			final Object... messageParameters) {
		if (!matcher.matches(actual)) {
			if (reason != null) {
				add(modularMessagesFactory.createI18n(category, reason,
						messageParameters));
			} else {
				final Description description = new ResourceBundleDescription();
				description.appendDescriptionOf(matcher);
				reason = description.toString();
				add(modularMessagesFactory.createI18n(category, reason));
			}
			return false;
		}
		return true;
	}
}
