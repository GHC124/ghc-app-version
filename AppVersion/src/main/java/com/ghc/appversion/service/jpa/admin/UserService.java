/**
 * UserService.java
 *
 *	
 */
package com.ghc.appversion.service.jpa.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ghc.appversion.domain.admin.User;

/**
 * 
 */
public interface UserService {
	List<User> findAll();

	User findById(Long id);

	User save(User User);

	Page<User> findAllByPage(Pageable pageable);
}
