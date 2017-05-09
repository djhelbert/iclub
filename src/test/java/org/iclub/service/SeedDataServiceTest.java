package org.iclub.service;

import org.iclub.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SeedDataServiceTest {

    @Autowired
    private SeedDataService seedDataService;

    @Autowired
    private UserService userService;

    @Test
    public void testService() {
    	seedDataService.init();

    	assert userService.findByRole(Role.ADMIN).get(0).getFirstName().equals("iClub");
    }
}
