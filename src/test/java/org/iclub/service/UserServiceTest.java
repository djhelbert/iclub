package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Role;
import org.iclub.model.User;
import org.iclub.model.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testService() {
    	userService.save(getUserForm("test@email.net", Role.USER, "pwd"));
    	Optional<User> optional = userService.getUserByEmail("test@email.net");
    	assert optional.isPresent();
    }

	public UserForm getUserForm(String email, Role role, String password) {
		UserForm user = new UserForm();
		user.setEmail(email);
		user.setRole(role);
		user.setFirstName("First");
		user.setLastName("Last");
		user.setCellPhone("555-555-5555");
		user.setHomePhone("555-555-6666");
		user.setPassword(password);
		user.setPasswordConfirm(password);
		return user;
	}
}
