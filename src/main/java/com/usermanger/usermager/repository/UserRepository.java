package com.usermanger.usermager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanger.usermager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	

}
