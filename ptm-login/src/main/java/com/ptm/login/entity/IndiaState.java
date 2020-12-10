package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "india_state", catalog = "ptmdb")
public class IndiaState implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "key", nullable = false, length = 5)
	private String key;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "capital", nullable = false, length = 50)
	private String capital;

	@Column(name = "language", nullable = false, length = 50)
	private String language;

	public IndiaState() {
	}

	public IndiaState(String key, String name, String capital, String language) {
		this.key = key;
		this.name = name;
		this.capital = capital;
		this.language = language;
	}

}
