package org.iclub.validator;

import org.iclub.model.SettingForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SettingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return SettingForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
    }
}
