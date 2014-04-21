/**
 * UserRepository.java
 *
 *	
 */
package com.ghc.appversion.repository.jpa.admin;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ghc.appversion.domain.admin.UserSummary;

/**
 * 
 */
public interface UserSummaryRepository extends PagingAndSortingRepository<UserSummary, Long> {
	
}
