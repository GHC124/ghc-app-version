/**
 * Group.java
 *
 *	
 */
package com.ghc.appversion.domain.admin;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ghc.appversion.domain.BaseEntity;

/**
 * 
 */
@Entity
@Table(name = "Groups")
public class Group extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long mId;
	private String mName;
	private Set<User> mUsers = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		mId = id;
	}

	@NotEmpty(message = "{validation.name.NotEmpty.message}")
	@Size(min = 1, max = 255, message = "{validation.name.Size.message}")
	@Column(name = "name")
	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
	public Set<User> getUsers() {
		return mUsers;
	}

	public void setUsers(Set<User> users) {
		mUsers = users;
	}

	
}
