package org.iclub.validator;

import org.iclub.model.UserForm;
import org.iclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        final UserForm userForm = (UserForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");

        if (userForm.getEmail().length() < 6 || userForm.getEmail().length() > 50) {
            errors.rejectValue("email", "email.size");
        }

        if (userService.getUserByEmail(userForm.getEmail()).isPresent()) {
            errors.rejectValue("email", "email.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "password.confirm.required");

        if (!userForm.getPasswordConfirm().equals(userForm.getPassword())) {
            errors.rejectValue("passwordConfirm", "password.confirm.different");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.required");

        if (!userForm.getAgree()) {
            errors.reject("agree.required");
        }

        if (!isValid(userForm.getAddressLine1())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getAddressLine2())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getCity())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getState())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getFirstName())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getLastName())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getZipCode())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getHomePhone())) {
            errors.reject("illegal.char");
        }
        if (!isValid(userForm.getCellPhone())) {
            errors.reject("illegal.char");
        }
    }

    private boolean isValid(String value) {
        if (value == null) {
            return true;
        }

        if (value.contains("<") || value.contains("<") || value.contains("/") || value.contains("!") || value.contains("#") || value.contains("$")) {
            return false;
        }

        return true;
    }
}
