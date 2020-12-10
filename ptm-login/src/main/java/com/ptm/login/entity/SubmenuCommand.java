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
@Table(name = "submenu_command", catalog = "ptmdb")
public class SubmenuCommand implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_command_id", nullable = false)
	private Command command;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_submenu_id", nullable = false)
	private Submenu submenu;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "submenuCommand")
	private Set<MenuSubmenuCommand> menuSubmenuCommands = new HashSet<MenuSubmenuCommand>(0);

	public SubmenuCommand() {
	}

	public SubmenuCommand(int id, Command command, Employee employeeByCreatedBy, Submenu submenu, boolean enabled,
			boolean secured, String description, LocalDateTime createdOn) {
		this.id = id;
		this.command = command;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.submenu = submenu;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
	}

	public SubmenuCommand(int id, Command command, Employee employeeByCreatedBy, Employee employeeByUpdatedBy,
			Submenu submenu, boolean enabled, boolean secured, String description, LocalDateTime createdOn,
			LocalDateTime updatedOn, Set<MenuSubmenuCommand> menuSubmenuCommands) {
		this.id = id;
		this.command = command;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.submenu = submenu;
		this.enabled = enabled;
		this.secured = secured;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.menuSubmenuCommands = menuSubmenuCommands;
	}

}
