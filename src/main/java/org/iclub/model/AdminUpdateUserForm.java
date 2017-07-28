package org.iclub.model;

public class AdminUpdateUserForm extends UpdateUserForm {

    private Long id;
    private String role;

    public AdminUpdateUserForm() {
    }

    public AdminUpdateUserForm(User user) {
        super(user);
        this.id = user.getId();
        if (Role.DISABLED == user.getRole()) {
            this.role = "DISABLED";
        } else {
            this.role = user.getRole() == Role.ADMIN ? "ADMIN" : "USER";
        }
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
        if ("DISABLED".equalsIgnoreCase(this.role)) {
            user.setRole(Role.DISABLED);
        } else {
            user.setRole("ADMIN".equalsIgnoreCase(this.role) ? Role.ADMIN : Role.USER);
        }
        return user;
    }
}
