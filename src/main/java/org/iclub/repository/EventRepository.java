package org.iclub.repository;

import java.util.Date;
import java.util.List;
import org.iclub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.timestamp >= :start and e.timestamp <= :end")
    List<Event> findByTimestamp(@Param("start") Date start, @Param("end") Date end);
}
