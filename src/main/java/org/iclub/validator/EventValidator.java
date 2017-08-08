package org.iclub.validator;

import java.text.ParseException;
import java.util.Date;

import org.iclub.model.EventForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EventForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");

        final EventForm eventForm = (EventForm) o;

        try {
            final Date now = new Date();
            if (eventForm.toEvent().getTimestamp() != null && eventForm.toEvent().getTimestamp().getTime() < now.getTime()) {
                errors.rejectValue("date", "date.future");
            }
        } catch (ParseException e) {
        }
    }
}
