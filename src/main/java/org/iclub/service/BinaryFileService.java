package org.iclub.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iclub.model.BinaryFile;

public interface BinaryFileService {

	public BinaryFile save(BinaryFile binaryFile);
	public BinaryFile saveResource(String path, String mimetype, Boolean logo, Boolean scroller, Boolean resource) throws IOException, URISyntaxException;
	public BinaryFile getBinaryFile(Long id);
	public Optional<BinaryFile> findBinaryFileByLogo(Boolean logo);
	public List<BinaryFile> findByScroller(Boolean scroller);
	public List<BinaryFile> findByResource(Boolean resource);

}
