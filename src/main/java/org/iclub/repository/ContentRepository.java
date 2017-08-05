package org.iclub.repository;

import java.util.Optional;

import org.iclub.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    Optional<Content> findContentByName(String name);

}
