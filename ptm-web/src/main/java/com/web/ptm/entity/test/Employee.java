package com.web.ptm.entity.test;
// Generated Nov 14, 2020, 7:25:24 AM by Hibernate Tools 5.2.12.Final

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "ptm_dev")
public class Employee implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

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

	@Column(name = "designation_id", nullable = false)
	private int designationId;

	@Column(name = "father_name", nullable = false, length = 50)
	private String fatherName;

	@Column(name = "mother_name", nullable = false, length = 50)
	private String motherName;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "mobile", nullable = false, length = 50)
	private String mobile;

	@Column(name = "phone", nullable = false, length = 50)
	private String phone;

	@Column(name = "india_state_id", nullable = false)
	private int indiaStateId;

	@Column(name = "disabled_reason", length = 50)
	private String disabledReason;

	@Column(name = "last_working_day", nullable = false, length = 10)
	private LocalDate lastWorkingDay;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "pincode", nullable = false)
	private int pincode;

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

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String displayName, String nickName, String password,
			LocalDate dateOfBirth, LocalDate dateOfJoining, String email, String gender, int designationId,
			String fatherName, String motherName, String address, String mobile, String phone, int indiaStateId,
			LocalDate lastWorkingDay, boolean enabled, int pincode, int createdBy, LocalDateTime createdOn) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.nickName = nickName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.gender = gender;
		this.designationId = designationId;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.mobile = mobile;
		this.phone = phone;
		this.indiaStateId = indiaStateId;
		this.lastWorkingDay = lastWorkingDay;
		this.enabled = enabled;
		this.pincode = pincode;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public Employee(int id, String firstName, String middleName, String lastName, String displayName, String nickName,
			String password, LocalDate dateOfBirth, LocalDate dateOfJoining, String email, String gender,
			int designationId, String fatherName, String motherName, String address, String mobile, String phone,
			int indiaStateId, String disabledReason, LocalDate lastWorkingDay, boolean enabled, int pincode,
			int createdBy, LocalDateTime createdOn, int updatedBy, LocalDateTime updatedOn) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.nickName = nickName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.gender = gender;
		this.designationId = designationId;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.mobile = mobile;
		this.phone = phone;
		this.indiaStateId = indiaStateId;
		this.disabledReason = disabledReason;
		this.lastWorkingDay = lastWorkingDay;
		this.enabled = enabled;
		this.pincode = pincode;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIndiaStateId() {
		return this.indiaStateId;
	}

	public void setIndiaStateId(int indiaStateId) {
		this.indiaStateId = indiaStateId;
	}

	public String getDisabledReason() {
		return this.disabledReason;
	}

	public void setDisabledReason(String disabledReason) {
		this.disabledReason = disabledReason;
	}

	public LocalDate getLastWorkingDay() {
		return this.lastWorkingDay;
	}

	public void setLastWorkingDay(LocalDate lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
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
