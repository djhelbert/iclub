package org.iclub.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "binary_file")
public class BinaryFile {

	@Id
	@Column(name = "id")
	private long id;

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

	/** 16MB */
	private static long MAX_FILE_SIZE = 16777215;

	public BinaryFile() {
	}

	public BinaryFile(File file, String mimetype, Boolean logo, Boolean scroller, Boolean resource ) throws IOException {
		name = file.getName();
		data = read(file);
		this.mimetype = mimetype;
		this.logo = logo;
		this.resource = resource;
		this.scroller = scroller;
	}

	private byte[] read(File file) throws IOException {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
