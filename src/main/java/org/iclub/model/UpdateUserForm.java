package org.iclub.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UpdateUserForm {

    private String email = "";
    private String password = "";
    private String passwordConfirm = "";
    private String firstName = "";
    private String lastName = "";
    private String homePhone = "";
    private String cellPhone = "";
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String city = "";
    private String state = "";
    private String zipCode = "";

    public UpdateUserForm() {
    }

    public UpdateUserForm(User user) {
        this.addressLine1 = user.getAddressLine1();
        this.addressLine2 = user.getAddressLine2();
        this.cellPhone = user.getCellPhone();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.homePhone = user.getHomePhone();
        this.lastName = user.getLastName();
        this.state = user.getState();
        this.zipCode = user.getZipCode();
        this.city = user.getCity();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser(Long id, Role role) {
        User user = new User();
        user.setId(id);
        user.setRole(role);
        user.setAddressLine1(addressLine1);
        user.setAddressLine2(addressLine2);
        user.setCellPhone(cellPhone);
        user.setHomePhone(homePhone);
        user.setCity(city);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setState(state);
        user.setZipCode(zipCode);
        user.setPasswordHash(new BCryptPasswordEncoder().encode(password));

        return user;
    }
}
