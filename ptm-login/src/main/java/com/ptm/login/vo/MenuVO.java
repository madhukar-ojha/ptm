package com.ptm.login.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuVO implements Comparable<MenuVO>, Serializable {
	private int id;
	private String menuKey;
	private String menuName;
	private String menuUrl;
	private String menuType;
	private int serialNo;
	private Set<SubMenuVO> subMenuList = new HashSet<SubMenuVO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public Set<SubMenuVO> getSubMenuList() {
	//	subMenuList = subMenuList.stream().sorted().collect(Collectors.toList());
		return subMenuList;
	}

	public void setSubMenuList(Set<SubMenuVO> subMenuList) {
		this.subMenuList = subMenuList;
	}

	@Override
	public int compareTo(MenuVO menuVO) {
		if (this.id < menuVO.id) {
			return -1;
		} else if (this.id == menuVO.id) {
			return 0;
		}
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof MenuVO) {
			MenuVO menuVO = (MenuVO) obj;
			if (this.id == menuVO.id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = this.menuName.hashCode();
		return hashCode;
	}
}
