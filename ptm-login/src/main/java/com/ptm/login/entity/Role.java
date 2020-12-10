package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "role", catalog = "ptmdb")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_department_id", nullable = false)
	private Department department;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_designation_id", nullable = false)
	private Designation designation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<RoleMenuSubmenuCommand> roleMenuSubmenuCommands = new HashSet<RoleMenuSubmenuCommand>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Role() {
	}

	public Role(int id, Department department, Designation designation, Employee employeeByCreatedBy, boolean enabled,
			String description, LocalDateTime createdOn) {
		this.id = id;
		this.department = department;
		this.designation = designation;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.enabled = enabled;
		this.description = description;
		this.createdOn = createdOn;
	}

	public Role(int id, Department department, Designation designation, Employee employeeByUpdatedBy,
			Employee employeeByCreatedBy, boolean enabled, String description, LocalDateTime createdOn,
			LocalDateTime updatedOn, Set<RoleMenuSubmenuCommand> roleMenuSubmenuCommands, Set<Employee> employees) {
		this.id = id;
		this.department = department;
		this.designation = designation;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.enabled = enabled;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.roleMenuSubmenuCommands = roleMenuSubmenuCommands;
		this.employees = employees;
	}

}
