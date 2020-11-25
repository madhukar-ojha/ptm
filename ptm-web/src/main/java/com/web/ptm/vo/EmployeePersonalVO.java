package com.web.ptm.vo;

import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
public class EmployeePersonalVO {
	private int id;
	private String action;
	@NotEmpty(message = "Enter first name")
	private String firstName;
	private String middleName;
	@NotEmpty(message = "Enter last name")
	private String lastName;
	private String nickName;
	private String displayName;
	private String fullName;
	@NotNull(message = "Select Gender")
	private String gender;
	private int department;
	private int role;
	private int designationName;
	@NotEmpty
	private String dateOfBirth;
	@NotEmpty(message = "Enter father name")
	private String fatherName;
	@NotEmpty(message = "Enter mother name")
	private String motherName;
	private String phone;
	@NotEmpty(message = "Enter mobile no")
	@NumberFormat
	private String mobile;
	@Email(message = "Enter email")
	private String email;
	@NotEmpty(message = "Enter address")
	private String address;
	@NumberFormat
	@Min(value = 6)
	@Min(value = 6, message = "pin code must be of 6 digits")
	private int pincode;
	@NumberFormat
	private int state;
	private String stateName;
	private String enabled;
	private String deleted;
	private int createdBy;
	private String createdOn;
	private int updatdeBy;
	private String updatdeOn;

	private Map<Integer, String> departmentMap;
	private Map<Integer, String> roleMap;
	private Map<Integer, String> stateMap;

	public EmployeePersonalVO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String active) {
		this.enabled = active;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getDesignationName() {
		return designationName;
	}

	public void setDesignationName(int designationName) {
		this.designationName = designationName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int creatdeBy) {
		this.createdBy = creatdeBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public int getUpdatdeBy() {
		return updatdeBy;
	}

	public void setUpdatdeBy(int updatdeBy) {
		this.updatdeBy = updatdeBy;
	}

	public String getUpdatdeOn() {
		return updatdeOn;
	}

	public Map<Integer, String> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Map<Integer, String> departmentMap) {
		this.departmentMap = departmentMap;
	}

	public Map<Integer, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<Integer, String> roleMap) {
		this.roleMap = roleMap;
	}

	public Map<Integer, String> getStateMap() {
		return stateMap;
	}

	public void setStateMap(Map<Integer, String> stateMap) {
		this.stateMap = stateMap;
	}

}
