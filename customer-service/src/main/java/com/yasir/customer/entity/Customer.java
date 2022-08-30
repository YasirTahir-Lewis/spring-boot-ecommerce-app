package com.yasir.customer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "customers_data")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name")
	private String userName;

	private String password;

	@Column(name = "email_address")
	@Email
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customer_name_id", referencedColumnName = "id")
	private CustomerName name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customer_address_id", nullable = false)
	private List<CustomerLocation> addresses;

	public Customer(String userName, String password, @Email String email, String phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CustomerName getName() {
		return name;
	}

	public void setName(CustomerName name) {
		this.name = name;
	}

	public List<CustomerLocation> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<CustomerLocation> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", name=" + name + ", addresses=" + addresses + "]";
	}

}
