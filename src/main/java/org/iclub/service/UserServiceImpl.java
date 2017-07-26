package org.iclub.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.Role;
import org.iclub.model.User;
import org.iclub.model.UserForm;
import org.iclub.model.UpdateUserForm;
import org.iclub.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void delete(Long id) {
        LOGGER.debug("Deleting user={}", id);

        userRepository.delete(id);
    }

    @Override
    public Optional<User> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);

        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));

        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findByRole(Role role) {
        LOGGER.debug("Getting user by role={}", role.name());

        return userRepository.findByRole(role);
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");

        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User save(UpdateUserForm userForm, Long id, Role role) {
        return userRepository.save(userForm.getUser(id, role));
    }

    @Override
    public User save(UserForm userForm) {
        return userRepository.save(userForm.getUser());
    }

}