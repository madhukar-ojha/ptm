package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "role_menu_submenu_command", catalog = "ptmdb")
public class RoleMenuSubmenuCommand implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_menu_submenu_command_id", nullable = false)
	private MenuSubmenuCommand menuSubmenuCommand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id", nullable = false)
	private Role role;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

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

	public RoleMenuSubmenuCommand() {
	}

	public RoleMenuSubmenuCommand(int id, MenuSubmenuCommand menuSubmenuCommand, Role role, String description,
			boolean enabled, int createdBy, LocalDateTime createdOn) {
		this.id = id;
		this.menuSubmenuCommand = menuSubmenuCommand;
		this.role = role;
		this.description = description;
		this.enabled = enabled;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public RoleMenuSubmenuCommand(int id, MenuSubmenuCommand menuSubmenuCommand, Role role, String description,
			boolean enabled, int createdBy, LocalDateTime createdOn, int updatedBy, LocalDateTime updatedOn) {
		this.id = id;
		this.menuSubmenuCommand = menuSubmenuCommand;
		this.role = role;
		this.description = description;
		this.enabled = enabled;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}
