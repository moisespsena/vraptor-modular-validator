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

import java.util.List;

import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validations;

public interface ModularValidator extends br.com.caelum.vraptor.Validator {
	public void add(MessageInfo messageInfo);

	public void add(final String category, final String reason,
			final Object... messageParameters);

	public void checking(final ModularValidations modularValidations);

	public void defaultOnError();

	public <T> T defaultOnErrorUse(final Class<T> controller);

	public List<Message> getErrors();

	public void onError();

	public void require(final ModularValidations modularValidations);

	public void require(Validations validations);

	public void reset();

	public void verifyError();
}
