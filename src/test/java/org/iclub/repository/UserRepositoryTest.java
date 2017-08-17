package org.iclub.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.iclub.model.Role;
import org.iclub.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest extends AbstractRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
    	entityManager.clear();
    }

    @Test
    public void testFindByEmail() {
        entityManager.persist(getUser("admin@email.com", Role.ADMIN, "hashed"));

        final Optional<User> usr = userRepository.findUserByEmail("admin@email.com");
        assertEquals("admin@email.com", usr.get().getEmail());

        final List<User> list = userRepository.findByRole(Role.ADMIN);
        assert list.size() > 0;
    }
}
