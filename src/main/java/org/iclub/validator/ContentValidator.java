package org.iclub.validator;

import org.iclub.model.ContentForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ContentForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    }
}
