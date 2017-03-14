package org.iclub.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.iclub.model.Role;
import org.iclub.model.User;
import org.iclub.model.UserForm;

public interface UserService {

	Optional<User> getUserById(long id);

	Optional<User> getUserByEmail(String email);

	List<User> findByRole(Role role);

	Collection<User> getAllUsers();

	User save(UserForm userForm);

}
