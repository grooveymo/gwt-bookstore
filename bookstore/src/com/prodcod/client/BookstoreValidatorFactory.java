package com.prodcod.client;

import javax.validation.Validator;
import javax.validation.groups.Default;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.prodcod.shared.ServersideGroup;
import com.prodcod.shared.User;

public final class BookstoreValidatorFactory extends AbstractGwtValidatorFactory {

	/**
	 * Validator marker for the Validation Sample project. Only the classes and groups listed
	 * in the {@link GwtValidation} annotation can be validated.
	 */
	@GwtValidation(value = User.class, groups = {Default.class, ServersideGroup.class})
	public interface GwtValidator extends Validator {
	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}
}