package org.iclub.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.BinaryFile;
import org.iclub.repository.BinaryFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BinaryFileServiceImpl implements BinaryFileService {

	@Autowired
	private BinaryFileRepository binaryFileRepository;

	@Override
	public BinaryFile save(BinaryFile binaryFile) {
		return binaryFileRepository.save(binaryFile);
	}

	@Override
	public BinaryFile saveResource(String path, String mimetype, Boolean logo, Boolean scroller, Boolean resource) throws IOException, URISyntaxException {
		final URL url = this.getClass().getResource(path);
		final File file = new File(url.toURI());
		return save(new BinaryFile(file, mimetype, logo, scroller, resource));
	}

	@Override
	public BinaryFile getBinaryFile(Long id) {
		return binaryFileRepository.findOne(id);
	}

	@Override
	public Optional<BinaryFile> findBinaryFileByLogo(Boolean logo) {
		return binaryFileRepository.findBinaryFileByLogo(logo);
	}

	@Override
	public List<BinaryFile> findByScroller(Boolean scroller) {
		return binaryFileRepository.findByScroller(scroller);
	}

	@Override
	public List<BinaryFile> findByResource(Boolean resource) {
		return binaryFileRepository.findByResource(resource);
	}
}