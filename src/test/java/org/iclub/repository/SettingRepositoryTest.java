package org.iclub.repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.iclub.model.Setting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SettingRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SettingRepository settingRepository;

    @Test
    public void testFindByName() {
        entityManager.persist(getSetting("test_name", "test_value"));

        final Optional<Setting> setting = settingRepository.findSettingByName("test_name");
        assertEquals("test_name", setting.get().getName());
        assertEquals("test_value", setting.get().getValue());
    }
}
