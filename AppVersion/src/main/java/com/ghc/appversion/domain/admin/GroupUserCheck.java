package com.ghc.appversion.domain.admin;

import java.io.Serializable;

/**
 * Select all groups and show groups that a user joined
 * 
 */
public class GroupUserCheck implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mId;
	private String mName;
	private Boolean mChecked;

	public GroupUserCheck(Integer id, String name, Boolean checked) {
		mId = id;
		mName = name;
		mChecked = checked;
	}

	public Integer getId() {
		return mId;
	}

	public void setId(Integer id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public Boolean getChecked() {
		return mChecked;
	}

	public void setChecked(Boolean checked) {
		mChecked = checked;
	}
}
