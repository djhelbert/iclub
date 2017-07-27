package org.iclub.model;

public class AdminUpdateUserForm extends UpdateUserForm {

    private Long id;
    private String role;

    public AdminUpdateUserForm() {
    }

    public AdminUpdateUserForm(User user) {
        super(user);
        this.id = user.getId();
        this.role = user.getRole() == Role.ADMIN ? "ADMIN" : "USER";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public User getUser(Long id, Role role) {
        final User user = super.getUser(id, role);
        user.setId(id);
        user.setRole("ADMIN".equalsIgnoreCase(this.role) ? Role.ADMIN : Role.USER);
        return user;
    }
}
