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
@Table(name = "contact_detail", catalog = "ptmdb")
public class ContactDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "type", nullable = false, length = 50)
	private String type;

	@Column(name = "number", nullable = false, length = 50)
	private String number;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contactDetail")
	private Set<Employee> employees = new HashSet<Employee>(0);

	public ContactDetail() {
	}

	public ContactDetail(int id, String type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public ContactDetail(int id, String type, String number, Set<Employee> employees) {
		this.id = id;
		this.type = type;
		this.number = number;
		this.employees = employees;
	}

}
