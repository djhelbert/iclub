package org.iclub.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

import javax.imageio.ImageIO;

import org.iclub.model.BinaryFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BinaryFileServiceTest {

    @Autowired
    private BinaryFileService binaryFileService;

    private static final String MIMETYPE = "image/png";

    @Test
    public void testRepository() {
        try {
            binaryFileService.save(BinaryFile.getBinaryFile("/image.png", MIMETYPE, false, false, true));

            List<BinaryFile> resources = binaryFileService.findByResource(Boolean.TRUE);
            assert resources.size() > 0;

            InputStream in = new ByteArrayInputStream(resources.get(0).getData());
            BufferedImage image = ImageIO.read(in);
            assert image.getHeight() == 32;
            assert image.getWidth() == 32;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            assert false;
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
