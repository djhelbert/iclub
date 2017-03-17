package org.iclub.repository;

import java.util.List;
import java.util.Optional;
import org.iclub.model.BinaryFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryFileRepository extends JpaRepository<BinaryFile, Long> {

	Optional<BinaryFile> findBinaryFileByLogo(Boolean logo);
	List<BinaryFile> findByScroller(Boolean scroller);
	List<BinaryFile> findByResource(Boolean resource);

}
