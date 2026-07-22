package com.appsv.financesaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsv.financesaccount.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Integer>{
	
}
