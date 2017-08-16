package org.iclub.validator;

import org.iclub.model.EmailForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return EmailForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating Email");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "body.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
    }
}
