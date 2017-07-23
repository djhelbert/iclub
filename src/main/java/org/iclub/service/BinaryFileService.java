package org.iclub.service;

import java.util.List;
import java.util.Optional;
import org.iclub.model.BinaryFile;

public interface BinaryFileService {

    public void delete(Long id);

    public BinaryFile save(BinaryFile binaryFile);

    public BinaryFile getBinaryFile(Long id);

    public Optional<BinaryFile> findBinaryFileByLogo(Boolean logo);

    public List<BinaryFile> findByScroller(Boolean scroller);

    public List<BinaryFile> findByResource(Boolean resource);

}
