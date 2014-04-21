/**
 * UserServiceImpl.java
 *
 *	
 */
package com.ghc.appversion.service.jpa.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghc.appversion.domain.admin.UserSummary;
import com.ghc.appversion.util.JpaUtil;

/**
 * 
 */
@Service("UserSummaryService")
@Repository
@Transactional
public class UserSummaryServiceImpl implements UserSummaryService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public Page<UserSummary> findAllByPage(Pageable pageable) {
		Query query = entityManager
				.createNativeQuery("SELECT distinct USER_ID, EMAIL, GROUP_CONCAT(GROUP_NAME) as GROUPNAMES FROM view_user_summary WHERE 1 group by USER_ID");
		List<UserSummary> result = JpaUtil.getResultList(query, UserSummary.class);
		
		Page<UserSummary> page = new PageImpl<>(result);
		return page;
	}
}
