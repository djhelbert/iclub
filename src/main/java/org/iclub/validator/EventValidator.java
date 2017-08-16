package org.iclub.validator;

import org.iclub.model.EventForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return EventForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validate Event");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
    }
}
