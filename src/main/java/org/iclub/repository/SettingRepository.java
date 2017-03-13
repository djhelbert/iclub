package org.iclub.repository;

import java.util.Optional;

import org.iclub.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

	Optional<Setting> findSettingByName(String name);

}
