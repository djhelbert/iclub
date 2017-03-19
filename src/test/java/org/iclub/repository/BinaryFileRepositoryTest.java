package org.iclub.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.iclub.model.BinaryFile;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BinaryFileRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BinaryFileRepository binaryFileRepository;

	private static final String MIMETYPE = "image/png";

	@After
	public void after() {
		entityManager.clear();
	}

	@Test
	public void testRepository() {
		try {
			binaryFileRepository.save(BinaryFile.getBinaryFile("/image.png", MIMETYPE, false, true, false));
			List<BinaryFile> scrollers = binaryFileRepository.findByScroller(true);
			assert scrollers.size() > 0;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			assert false;
		} catch (IOException e) {
			e.printStackTrace();
			assert false;
		}
	}
}
