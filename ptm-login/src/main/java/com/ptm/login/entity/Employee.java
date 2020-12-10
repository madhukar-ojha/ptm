package com.ptm.login.entity;
// Generated Dec 9, 2020, 9:28:15 PM by Hibernate Tools 5.2.12.Final

import java.time.LocalDate;
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
@Table(name = "employee", catalog = "ptmdb")
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1000L;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address_id", nullable = false)
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_contact_detail_id", nullable = false)
	private ContactDetail contactDetail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private Employee employeeByCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by")
	private Employee employeeByUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id", nullable = false)
	private Role role;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "full_name", nullable = false, length = 50)
	private String fullName;

	@Column(name = "display_name", nullable = false, length = 50)
	private String displayName;

	@Column(name = "nick_name", nullable = false, length = 50)
	private String nickName;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "date_of_birth", nullable = false, length = 10)
	private LocalDate dateOfBirth;

	@Column(name = "date_of_joining", nullable = false, length = 10)
	private LocalDate dateOfJoining;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "gender", nullable = false, length = 6)
	private String gender;

	@Column(name = "father_name", nullable = false, length = 50)
	private String fatherName;

	@Column(name = "mother_name", nullable = false, length = 50)
	private String motherName;

	@Column(name = "disabled_reason", length = 50)
	private String disabledReason;

	@Column(name = "last_working_day", nullable = false, length = 10)
	private LocalDate lastWorkingDay;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "created_on", nullable = false, length = 19)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updated_on", length = 19)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Role> rolesForUpdatedBy = new HashSet<Role>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Menu> menusForCreatedBy = new HashSet<Menu>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Employee> employeesForCreatedBy = new HashSet<Employee>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<MenuSubmenuCommand> menuSubmenuCommandsForCreatedBy = new HashSet<MenuSubmenuCommand>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Department> departmentsForCreatedBy = new HashSet<Department>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Department> departmentsForUpdatedBy = new HashSet<Department>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Command> commandsForUpdatedBy = new HashSet<Command>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<SubmenuDependency> submenuDependenciesForCreatedBy = new HashSet<SubmenuDependency>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Command> commandsForCreatedBy = new HashSet<Command>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<SubmenuDependency> submenuDependenciesForUpdatedBy = new HashSet<SubmenuDependency>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Designation> designationsForCreatedBy = new HashSet<Designation>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Menu> menusForUpdatedBy = new HashSet<Menu>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<MenuSubmenuCommand> menuSubmenuCommandsForUpdatedBy = new HashSet<MenuSubmenuCommand>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<SubmenuCommand> submenuCommandsForCreatedBy = new HashSet<SubmenuCommand>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<SubmenuCommand> submenuCommandsForUpdatedBy = new HashSet<SubmenuCommand>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Submenu> submenusForCreatedBy = new HashSet<Submenu>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Employee> employeesForUpdatedBy = new HashSet<Employee>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByCreatedBy")
	private Set<Role> rolesForCreatedBy = new HashSet<Role>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Submenu> submenusForUpdatedBy = new HashSet<Submenu>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByUpdatedBy")
	private Set<Designation> designationsForUpdatedBy = new HashSet<Designation>(0);

	public Employee() {
	}

	public Employee(Address address, ContactDetail contactDetail, Employee employeeByCreatedBy, Role role,
			String firstName, String lastName, String fullName, String displayName, String nickName, String password,
			LocalDate dateOfBirth, LocalDate dateOfJoining, String email, String gender, String fatherName,
			String motherName, LocalDate lastWorkingDay, boolean enabled, LocalDateTime createdOn) {
		this.address = address;
		this.contactDetail = contactDetail;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.displayName = displayName;
		this.nickName = nickName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.lastWorkingDay = lastWorkingDay;
		this.enabled = enabled;
		this.createdOn = createdOn;
	}

	public Employee(Address address, ContactDetail contactDetail, Employee employeeByCreatedBy,
			Employee employeeByUpdatedBy, Role role, String firstName, String middleName, String lastName,
			String fullName, String displayName, String nickName, String password, LocalDate dateOfBirth,
			LocalDate dateOfJoining, String email, String gender, String fatherName, String motherName,
			String disabledReason, LocalDate lastWorkingDay, boolean enabled, LocalDateTime createdOn,
			LocalDateTime updatedOn, Set<Role> rolesForUpdatedBy, Set<Menu> menusForCreatedBy,
			Set<Employee> employeesForCreatedBy, Set<MenuSubmenuCommand> menuSubmenuCommandsForCreatedBy,
			Set<Department> departmentsForCreatedBy, Set<Department> departmentsForUpdatedBy,
			Set<Command> commandsForUpdatedBy, Set<SubmenuDependency> submenuDependenciesForCreatedBy,
			Set<Command> commandsForCreatedBy, Set<SubmenuDependency> submenuDependenciesForUpdatedBy,
			Set<Designation> designationsForCreatedBy, Set<Menu> menusForUpdatedBy,
			Set<MenuSubmenuCommand> menuSubmenuCommandsForUpdatedBy, Set<SubmenuCommand> submenuCommandsForCreatedBy,
			Set<SubmenuCommand> submenuCommandsForUpdatedBy, Set<Submenu> submenusForCreatedBy,
			Set<Employee> employeesForUpdatedBy, Set<Role> rolesForCreatedBy, Set<Submenu> submenusForUpdatedBy,
			Set<Designation> designationsForUpdatedBy) {
		this.address = address;
		this.contactDetail = contactDetail;
		this.employeeByCreatedBy = employeeByCreatedBy;
		this.employeeByUpdatedBy = employeeByUpdatedBy;
		this.role = role;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.displayName = displayName;
		this.nickName = nickName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.disabledReason = disabledReason;
		this.lastWorkingDay = lastWorkingDay;
		this.enabled = enabled;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.rolesForUpdatedBy = rolesForUpdatedBy;
		this.menusForCreatedBy = menusForCreatedBy;
		this.employeesForCreatedBy = employeesForCreatedBy;
		this.menuSubmenuCommandsForCreatedBy = menuSubmenuCommandsForCreatedBy;
		this.departmentsForCreatedBy = departmentsForCreatedBy;
		this.departmentsForUpdatedBy = departmentsForUpdatedBy;
		this.commandsForUpdatedBy = commandsForUpdatedBy;
		this.submenuDependenciesForCreatedBy = submenuDependenciesForCreatedBy;
		this.commandsForCreatedBy = commandsForCreatedBy;
		this.submenuDependenciesForUpdatedBy = submenuDependenciesForUpdatedBy;
		this.designationsForCreatedBy = designationsForCreatedBy;
		this.menusForUpdatedBy = menusForUpdatedBy;
		this.menuSubmenuCommandsForUpdatedBy = menuSubmenuCommandsForUpdatedBy;
		this.submenuCommandsForCreatedBy = submenuCommandsForCreatedBy;
		this.submenuCommandsForUpdatedBy = submenuCommandsForUpdatedBy;
		this.submenusForCreatedBy = submenusForCreatedBy;
		this.employeesForUpdatedBy = employeesForUpdatedBy;
		this.rolesForCreatedBy = rolesForCreatedBy;
		this.submenusForUpdatedBy = submenusForUpdatedBy;
		this.designationsForUpdatedBy = designationsForUpdatedBy;
	}

}
