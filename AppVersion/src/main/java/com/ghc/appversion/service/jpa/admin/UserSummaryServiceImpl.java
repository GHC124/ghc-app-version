/**
 * UserServiceImpl.java
 *
 *	
 */
package com.ghc.appversion.service.jpa.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghc.appversion.domain.admin.UserSummary;
import com.ghc.appversion.repository.jpa.admin.UserSummaryRepository;

/**
 * 
 */
@Service("UserSummaryService")
@Repository
@Transactional
public class UserSummaryServiceImpl implements UserSummaryService {
	
	@Autowired
	private UserSummaryRepository userSummaryRepository;	
		
	@Override
	public Page<UserSummary> findAllByPage(Pageable pageable) {
		return userSummaryRepository.findAll(pageable);
	}

}
