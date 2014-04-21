/**
 * UserServiceImpl.java
 *
 *	
 */
package com.ghc.appversion.service.jpa.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghc.appversion.domain.admin.User;
import com.ghc.appversion.repository.jpa.admin.UserRepository;
import com.ghc.appversion.util.ListUtil;

/**
 * 
 */
@Service("UserService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;	
	
	/* (non-Javadoc)
	 * @see com.ghc.service.jpa.UserService#findAll()
	 */
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return ListUtil.newArrayList(userRepository.findAll());
	}

	/* (non-Javadoc)
	 * @see com.ghc.service.jpa.UserService#findById(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.ghc.service.jpa.UserService#save(com.ghc.domain.User)
	 */
	@Override
	public User save(User User) {
		return userRepository.save(User);
	}

	@Override
	public Page<User> findAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

}
