package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "designation", catalog = "ptmdb")
public class Designation implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@Column(name = "key", nullable = false, length = 50)
	private String key;

	@Column(name = "short_name", nullable = false, length = 50)
	private String shortName;

	@Column(name = "full_name", nullable = false, length = 50)
	private String fullName;

	@Column(name = "hierarchy", nullable = false)
	private int hierarchy;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "designation")
	private Set<Role> roles = new HashSet<Role>(0);

	public Designation() {
	}

	public Designation(Employee employeeByCreatedBy, String key, String shortName, String fullName, int hierarchy,
			boolean enabled, String description, LocalDateTime createdOn) {
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.key = key;
		this.shortName = shortName;
		this.fullName = fullName;
		this.hierarchy = hierarchy;
		this.enabled = enabled;
		this.description = description;
		this.createdOn = createdOn;
	}

	public Designation(Employee employeeByCreatedBy, Employee employeeByUpdatedBy, String key, String shortName,
			String fullName, int hierarchy, boolean enabled, String description, LocalDateTime createdOn,
			LocalDateTime updatedOn, Set<Role> roles) {
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.key = key;
		this.shortName = shortName;
		this.fullName = fullName;
		this.hierarchy = hierarchy;
		this.enabled = enabled;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.roles = roles;
	}

}
