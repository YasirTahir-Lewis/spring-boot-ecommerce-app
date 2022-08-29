package com.yasir.user.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "address_details")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "street_number")
	private String streetNumber;

	@Column(name = "unit/apt")
	private String unitApt;

	@NotNull
	private String city;

	@NotNull
	private String state;

	@Max(value = 99999)
	private int zipCode;
	
//	@ManyToOne
//	@JoinColumn(name = "fk_user_address", nullable = false, referencedColumnName = "id")
//	private User user;

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getUnitApt() {
		return unitApt;
	}

	public void setUnitApt(String unitApt) {
		this.unitApt = unitApt;
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Address(@NotNull String streetNumber, String unitApt, @NotNull String city, @NotNull String state,
			@Max(99999) int zipCode) {
		this.streetNumber = streetNumber;
		this.unitApt = unitApt;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Address() {

	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetNumber=" + streetNumber + ", unitApt=" + unitApt + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + "]";
	}

}
