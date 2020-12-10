package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address", catalog = "ptmdb")
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "type", nullable = false, length = 50)
	private String type;

	@Column(name = "area", nullable = false, length = 50)
	private String area;

	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Column(name = "district", nullable = false, length = 50)
	private String district;

	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@Column(name = "pincode", nullable = false)
	private int pincode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Address() {
	}

	public Address(int id, String type, String area, String city, String district, String state, int pincode) {
		this.id = id;
		this.type = type;
		this.area = area;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public Address(int id, String type, String area, String city, String district, String state, int pincode,
			Set<Employee> employees) {
		this.id = id;
		this.type = type;
		this.area = area;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.employees = employees;
	}

}
