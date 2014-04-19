package com.ghc.appversion.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ghc.appversion.domain.BaseEntity;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {
	private Long mId;
	private String mEmail;
	private String mFirstName;
	private String mLastName;
	private int mIsActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		mId = id;
	}
	
	@NotEmpty(message = "{validation.email.NotEmpty.message}")
	@Size(min = 1, max = 255, message = "{validation.email.Size.message}")
	@Column(name = "email")
	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String email) {
		mEmail = email;
	}

	@NotEmpty(message = "{validation.firstname.NotEmpty.message}")
	@Size(min = 3, max = 255, message = "{validation.firstname.Size.message}")
	@Column(name = "first_name")
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	@Size(min = 0, max = 255, message = "{validation.lastname.Size.message}")
	@Column(name = "last_name")
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}	

	@Column(name = "is_active")
	public int getIsActive() {
		return mIsActive;
	}

	public void setIsActive(int isActive) {
		mIsActive = isActive;
	}

}