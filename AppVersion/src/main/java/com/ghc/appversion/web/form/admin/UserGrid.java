package com.ghc.appversion.web.form.admin;

import java.util.List;

import com.ghc.appversion.domain.admin.User;

public class UserGrid {
	private int mTotalPages;
	private int mCurrentPage;
	private long mTotalRecords;
	private List<User> mUserData;
	
	public int getTotalPages() {
		return mTotalPages;
	}
	public void setTotalPages(int totalPages) {
		mTotalPages = totalPages;
	}
	public int getCurrentPage() {
		return mCurrentPage;
	}
	public void setCurrentPage(int currentPage) {
		mCurrentPage = currentPage;
	}
	public long getTotalRecords() {
		return mTotalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		mTotalRecords = totalRecords;
	}
	public List<User> getUserData() {
		return mUserData;
	}
	public void setUserData(List<User> userData) {
		mUserData = userData;
	}
}
