package org.iclub.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Entity
@Table(name = "binary_file")
public class BinaryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = false, length = 50)
    private String name;

    @Column(name = "mimetype", nullable = false, unique = false, length = 100)
    private String mimetype;

    @Column(name = "logo", nullable = false, unique = false)
    private Boolean logo = Boolean.FALSE;

    @Column(name = "scroller", nullable = false, unique = false)
    private Boolean scroller = Boolean.FALSE;

    @Column(name = "resource", nullable = false, unique = false)
    private Boolean resource = Boolean.FALSE;

    @Lob
    private byte[] data;

    /** 32MB */
    private static long MAX_FILE_SIZE = 320000000;

    public static BinaryFile getBinaryFile(String path, String mimetype, Boolean logo, Boolean scroller,
            Boolean resource, ResourceLoader resourceLoader) throws IOException, URISyntaxException {
        final Resource fileResource = resourceLoader.getResource("classpath:" + path);
        final File file = fileResource.getFile();

        BinaryFile bf = new BinaryFile();

        bf.setName(file.getName());
        bf.setData(read(file));
        bf.setMimetype(mimetype);
        bf.setLogo(logo);
        bf.setResource(resource);
        bf.setScroller(scroller);

        return bf;
    }

    private static byte[] read(File file) throws IOException {
        if (file.length() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException();
        }

        final byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;

        try {
            ios = new FileInputStream(file);

            if (ios.read(buffer) == -1) {
                throw new IOException();
            }
        } finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
            }
        }

        return buffer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImage() {
        if (mimetype != null && mimetype.startsWith("image")) {
            return true;
        } else {
            return false;
        }
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Boolean getLogo() {
        return logo;
    }

    public void setLogo(Boolean logo) {
        this.logo = logo;
    }

    public Boolean getScroller() {
        return scroller;
    }

    public void setScroller(Boolean scroller) {
        this.scroller = scroller;
    }

    public Boolean getResource() {
        return resource;
    }

    public void setResource(Boolean resource) {
        this.resource = resource;
    }

    public int getDataSize() {
        return data == null ? 0 : (data.length/1000);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryFile{id=" + id + ", mimetype='" + mimetype + ", name='" + name + '}';
    }
}
