package com.appsv.financesaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsv.financesaccount.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
