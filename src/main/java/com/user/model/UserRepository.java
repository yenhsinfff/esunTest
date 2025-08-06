package com.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer>{

	UserVO findByPhone(String Phone);
	
	boolean existsByPhone(String phone);
	
	boolean existsByEmail(String email);
}
