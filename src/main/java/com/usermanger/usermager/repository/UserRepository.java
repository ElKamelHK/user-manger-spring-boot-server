package com.usermanger.usermager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanger.usermager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
Optional<User> findByCin(String cin);
Optional<User> findByUsername(String username);
}
