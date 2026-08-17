package com.appsv.financesaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appsv.financesaccount.model.Category;
import com.appsv.financesaccount.service.BankService;
import com.appsv.financesaccount.service.CategoryService;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    private final CategoryService categoryService;
    private final BankService bankService;

    public CategoryController(CategoryService categoryService, BankService bankService) {
        this.categoryService = categoryService;
        this.bankService = bankService;
    }

    @GetMapping("/nueva")
    public String formularioNuevaCategoria(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("bancos", bankService.obtenerTodos());
        return "categorias/form-categoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("category") Category category){
        categoryService.guardar(category);
        return "redirect:/";
    }
}
