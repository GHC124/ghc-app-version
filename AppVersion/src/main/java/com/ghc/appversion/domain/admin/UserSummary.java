/**
 * UserSummary.java
 *
 *	
 */
package com.ghc.appversion.domain.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class UserSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long mUserId;
	private String mEmail;
	private Map<Integer, Group> mGroups = new HashMap<>(0);

	public Long getUserId() {
		return mUserId;
	}

	public void setUserId(Long userId) {
		mUserId = userId;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String email) {
		mEmail = email;
	}

	public Map<Integer, Group> getGroups() {
		return mGroups;
	}

	public void setGroups(Map<Integer, Group> groups) {
		mGroups = groups;
	}

	public String getGroupNames() {
		StringBuilder sb = new StringBuilder();
		for (Group group : mGroups.values()) {
			sb.append(group.getName());
			sb.append(',');
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

}
