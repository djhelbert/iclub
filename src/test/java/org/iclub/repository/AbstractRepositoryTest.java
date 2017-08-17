package org.iclub.repository;

import org.iclub.model.Role;
import org.iclub.model.Setting;
import org.iclub.model.User;

public class AbstractRepositoryTest {

    public User getUser(String email, Role role, String passwordHash) {
        User user = new User();
        user.setEmail(email);
        user.setRole(role);
        user.setPasswordHash(passwordHash);
        user.setFirstName("First");
        user.setLastName("Last");
        user.setCellPhone("555-555-5555");
        user.setHomePhone("555-555-6666");
        return user;
    }

    public Setting getSetting(String name, String value) {
        Setting setting = new Setting();
        setting.setName(name);
        setting.setValue(value);
        return setting;
    }
}
