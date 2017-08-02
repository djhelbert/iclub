package org.iclub.validator;

import org.iclub.model.EmailForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EmailForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromEmail", "fromEmail.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "body.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
    }
}
