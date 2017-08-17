package org.iclub.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.iclub.model.BinaryFile;
import org.iclub.model.Sponsor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SponsorServiceTest {

    private static final String MIMETYPE = "image/png";

    @Autowired
    private SponsorService sponsorService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void testService() {
        sponsorService.save(getSponsor());

        List<Sponsor> sponsors = sponsorService.findAll();
        assert sponsors.size() == 1;
    }

    private Sponsor getSponsor() {
        final Sponsor sponsor = new Sponsor();
        sponsor.setDescription("description");
        sponsor.setName("name");
        try {
            sponsor.setBinaryFile(BinaryFile.getBinaryFile("/image.png", MIMETYPE, false, false, true, resourceLoader));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            assert false;
        }
        return sponsor;
    }
}
