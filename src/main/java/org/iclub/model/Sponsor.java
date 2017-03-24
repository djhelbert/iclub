package org.iclub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sponsor")
public class Sponsor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", nullable = true, unique = false, length = 50)
	private String name;

	@Column(name = "url", nullable = true, unique = false, length = 50)
	private String url;

	@Column(name = "description", nullable = true, unique = false, length = 250)
	private String description;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="binary_file_id", unique= true, nullable=true, insertable=true, updatable=true)
	private BinaryFile binaryFile;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BinaryFile getBinaryFile() {
		return binaryFile;
	}

	public void setBinaryFile(BinaryFile binaryFile) {
		this.binaryFile = binaryFile;
	}

	@Override
	public String toString() {
		return "Sponsor{id=" + id + ", name='" +name + ", description='" + description + '}';
	}
}
