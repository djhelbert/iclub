package org.iclub.repository;

import java.util.List;
import java.util.Optional;

import org.iclub.model.Role;
import org.iclub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    
    List<User> findByRole(Role role);
    
}
