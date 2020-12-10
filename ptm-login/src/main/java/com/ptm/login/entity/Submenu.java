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
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "submenu", catalog = "ptmdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id", "sequence_no" }), @UniqueConstraint(columnNames = "key"),
		@UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "url") })
public class Submenu implements java.io.Serializable {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_submenu_dependency")
	private SubmenuDependency submenuDependency;

	@Column(name = "key", unique = true, nullable = false, length = 50)
	private String key;

	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;

	@Column(name = "url", unique = true, nullable = false, length = 50)
	private String url;

	@Column(name = "sequence_no", nullable = false)
	private int sequenceNo;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "secured", nullable = false)
	private boolean secured;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "submenuByFkSubmenuDependencyId")
	private Set<SubmenuDependency> submenuDependenciesForFkSubmenuDependencyId = new HashSet<SubmenuDependency>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "submenuByFkSubmenuId")
	private Set<SubmenuDependency> submenuDependenciesForFkSubmenuId = new HashSet<SubmenuDependency>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "submenu")
	private Set<SubmenuCommand> submenuCommands = new HashSet<SubmenuCommand>(0);

	public Submenu() {
	}

	public Submenu(Employee employeeByCreatedBy, String key, String name, String url, int sequenceNo, boolean enabled,
			boolean secured, String description, LocalDateTime createdOn) {
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.key = key;
		this.name = name;
		this.url = url;
		this.sequenceNo = sequenceNo;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
	}

	public Submenu(Employee employeeByCreatedBy, Employee employeeByUpdatedBy, SubmenuDependency submenuDependency,
			String key, String name, String url, int sequenceNo, boolean enabled, boolean secured, String description,
			LocalDateTime createdOn, LocalDateTime updatedOn,
			Set<SubmenuDependency> submenuDependenciesForFkSubmenuDependencyId,
			Set<SubmenuDependency> submenuDependenciesForFkSubmenuId, Set<SubmenuCommand> submenuCommands) {
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.submenuDependency = submenuDependency;
		this.key = key;
		this.name = name;
		this.url = url;
		this.sequenceNo = sequenceNo;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.submenuDependenciesForFkSubmenuDependencyId = submenuDependenciesForFkSubmenuDependencyId;
		this.submenuDependenciesForFkSubmenuId = submenuDependenciesForFkSubmenuId;
		this.submenuCommands = submenuCommands;
	}

}
