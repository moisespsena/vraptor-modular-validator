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

import java.util.ResourceBundle;

import br.com.caelum.vraptor.validator.I18nMessage;

/**
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 29/06/2011
 * 
 */
public interface ModularMessagesFactory {
	public class MessageBundleInfo {
		private final ResourceBundle bundle;
		private final String key;

		public MessageBundleInfo(final ResourceBundle bundle, final String key) {
			super();
			this.bundle = bundle;
			this.key = key;
		}

		public ResourceBundle getBundle() {
			return bundle;
		}

		public String getKey() {
			return key;
		}
	}

	public I18nMessage createI18n(final MessageInfo messageInfo);

	public I18nMessage createI18n(final String category, final String reason,
			final Object... parameters);

	public MessageBundleInfo getInfo(final String key);
}
