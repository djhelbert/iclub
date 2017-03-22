package org.iclub.validator;

import org.iclub.model.SponsorForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SponsorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SponsorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	}
}
