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
@Table(name = "command", catalog = "ptmdb")
public class Command implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@Column(name = "key", nullable = false, length = 50)
	private String key;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "type", nullable = false, length = 50)
	private String type;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "command")
	private Set<SubmenuCommand> submenuCommands = new HashSet<SubmenuCommand>(0);

	public Command() {
	}

	public Command(Employee employeeByCreatedBy, String key, String name, String type, String description,
			LocalDateTime createdOn) {
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.key = key;
		this.name = name;
		this.type = type;
		this.description = description;
		this.createdOn = createdOn;
	}

	public Command(Employee employeeByUpdatedBy, Employee employeeByCreatedBy, String key, String name, String type,
			String description, LocalDateTime createdOn, LocalDateTime updatedOn, Set<SubmenuCommand> submenuCommands) {
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.key = key;
		this.name = name;
		this.type = type;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.submenuCommands = submenuCommands;
	}

}
