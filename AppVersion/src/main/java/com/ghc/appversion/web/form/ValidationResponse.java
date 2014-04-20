package com.ghc.appversion.web.form;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ValidationResponse {
	private String mStatus;
	 private List<ObjectError> mResult;

	 public String getStatus() {
	   return mStatus;
	 }
	 public void setStatus(String status) {
	   this.mStatus = status;
	 }
	 public List<ObjectError> getResult() {
	   return this.mResult;
	 }
	 public void setResult(List<ObjectError> result) {
	   this.mResult = result;
	 }
}
