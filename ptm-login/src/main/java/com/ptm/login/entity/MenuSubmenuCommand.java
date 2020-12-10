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
@Table(name = "menu_submenu_command", catalog = "ptmdb")
public class MenuSubmenuCommand implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_menu_id", nullable = false)
	private Menu menu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_submenu_command_id", nullable = false)
	private SubmenuCommand submenuCommand;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuSubmenuCommand")
	private Set<RoleMenuSubmenuCommand> roleMenuSubmenuCommands = new HashSet<RoleMenuSubmenuCommand>(0);

	public MenuSubmenuCommand() {
	}

	public MenuSubmenuCommand(int id, Employee employeeByCreatedBy, Menu menu, SubmenuCommand submenuCommand,
			boolean enabled, boolean secured, String description, LocalDateTime createdOn) {
		this.id = id;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.menu = menu;
		this.submenuCommand = submenuCommand;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
	}

	public MenuSubmenuCommand(int id, Employee employeeByCreatedBy, Employee employeeByUpdatedBy, Menu menu,
			SubmenuCommand submenuCommand, boolean enabled, boolean secured, String description,
			LocalDateTime createdOn, LocalDateTime updatedOn, Set<RoleMenuSubmenuCommand> roleMenuSubmenuCommands) {
		this.id = id;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.menu = menu;
		this.submenuCommand = submenuCommand;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.roleMenuSubmenuCommands = roleMenuSubmenuCommands;
	}

}
