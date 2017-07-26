package org.iclub.validator;

import org.iclub.model.UpdateUserForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserUpdateValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateUserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        final UpdateUserForm userForm = (UpdateUserForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");

        if (userForm.getEmail().length() < 6 || userForm.getEmail().length() > 50) {
            errors.rejectValue("email", "email.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "password.confirm.required");

        if (!userForm.getPasswordConfirm().equals(userForm.getPassword())) {
            errors.rejectValue("passwordConfirm", "password.confirm.different");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.required");
    }
}
