package org.iclub.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "first_name", nullable = false, unique = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, unique = false)
	private String lastName;
	
	@Column(name = "home_phone", nullable = true, unique = false)
	private String homePhone;
	
	@Column(name = "cell_phone", nullable = true, unique = false)
	private String cellPhone;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "address_line_1", nullable = true, unique = false)
	private String addressLine1;
	
	@Column(name = "address_line_2", nullable = true, unique = false)
	private String addressLine2;
	
	@Column(name = "city", nullable = true, unique = false)
	private String city;
	
	@Column(name = "state", nullable = true, unique = false)
	private String state;
	
	@Column(name = "zip_code", nullable = true, unique = false)
	private String zipCode;
	
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
    
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "User{id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='" + passwordHash + ", role=" + role + '}';
	}
}
