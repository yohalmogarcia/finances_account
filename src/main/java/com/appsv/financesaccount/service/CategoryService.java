package com.appsv.financesaccount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appsv.financesaccount.model.Category;
import com.appsv.financesaccount.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> obtenerPorBanco(Integer bankId){
        return categoryRepository.findByBankPkBank(bankId);
    }

    public Category guardar(Category category){
        return categoryRepository.save(category);
    }
}
