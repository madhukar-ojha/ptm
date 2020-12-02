package com.ptm.main.entity.test;
// Generated Nov 14, 2020, 7:25:24 AM by Hibernate Tools 5.2.12.Final

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Designation generated by hbm2java
 */
@Entity
@Table(name = "designation", catalog = "ptm_dev", uniqueConstraints = @UniqueConstraint(columnNames = { "role_id",
		"department_id" }))
public class Designation implements java.io.Serializable {

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "department_id", nullable = false)
	private int departmentId;

	@Column(name = "role_id", nullable = false)
	private int roleId;

	@Column(name = "department", nullable = false, length = 50)
	private String department;

	@Column(name = "role_name", nullable = false, length = 50)
	private String roleName;

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	@Column(name = "designation", length = 50)
	private String designation;

	@Column(name = "enabled", nullable = false, length = 5)
	private String enabled;

	@Column(name = "hierarchy", nullable = false)
	private int hierarchy;

	@Column(name = "deleted", nullable = false, length = 5)
	private String deleted;

	@Column(name = "created_by", nullable = false)
	private int createdBy;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_by")
	private int updatedBy;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	public Designation() {
	}

	public Designation(int id, int departmentId, int roleId, String department, String roleName, String description,
			String enabled, int hierarchy, String deleted, int createdBy, LocalDateTime createdOn) {
		this.id = id;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.department = department;
		this.roleName = roleName;
		this.description = description;
		this.enabled = enabled;
		this.hierarchy = hierarchy;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public Designation(int id, int departmentId, int roleId, String department, String roleName, String description,
			String designation, String enabled, int hierarchy, String deleted, int createdBy, LocalDateTime createdOn,
			int updatedBy, LocalDateTime updatedOn) {
		this.id = id;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.department = department;
		this.roleName = roleName;
		this.description = description;
		this.designation = designation;
		this.enabled = enabled;
		this.hierarchy = hierarchy;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}