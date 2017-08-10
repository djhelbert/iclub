package org.iclub.repository;

import java.util.List;

import org.iclub.model.WeeklyEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyEventRepository extends JpaRepository<WeeklyEvent, Long> {
    @Query("select e from WeeklyEvent e order by e.dayOfWeek, e.time")
    List<WeeklyEvent> findAllOrderByDayTime();
}
