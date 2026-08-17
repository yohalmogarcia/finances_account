package com.appsv.financesaccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsv.financesaccount.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    List<Category> findByBankPkBank(Integer pkBank);
}
