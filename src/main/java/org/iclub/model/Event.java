package org.iclub.model;

import java.net.URLEncoder;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "event", indexes = @Index(name = "event_index_timestamp", columnList="timestamp", unique = false))
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = false, length = 50)
    private String name;

    @Column(name = "description", nullable = true, unique = false, length = 250)
    private String description;

    @Column(name = "url", nullable = true, unique = false, length = 250)
    private String url;

    @Column(name = "address", nullable = true, unique = false, length = 250)
    private String address;

    @Column(name = "timestamp", nullable = true, updatable = true)
    private Date timestamp;

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

    public String getEncodedUrl() {
        return URLEncoder.encode(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
