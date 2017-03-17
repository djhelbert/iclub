package org.iclub.repository;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.iclub.model.BinaryFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BinaryFileRepositoryTest {

    @Autowired
    private BinaryFileRepository binaryFileRepository;

	private static final String MIMETYPE = "image/png";

	@Test
	public void testRepository() {
		URL url = this.getClass().getResource("/image.png");

		try {
			File file = new File(url.toURI());
			binaryFileRepository.save(new BinaryFile(file, MIMETYPE, true, false, false));
			BinaryFile bin = binaryFileRepository.findBinaryFileByLogo(true).get();
			assert bin.getLogo();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			assert false;
		} catch (IOException e) {
			e.printStackTrace();
			assert false;
		}
	}
}
