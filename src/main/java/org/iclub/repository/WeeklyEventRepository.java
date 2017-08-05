package org.iclub.repository;

import org.iclub.model.WeeklyEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyEventRepository extends JpaRepository<WeeklyEvent, Long> {
}
