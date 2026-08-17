package com.appsv.financesaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appsv.financesaccount.model.Bank;
import com.appsv.financesaccount.service.BankService;

@Controller
@RequestMapping("/bancos")
public class BankController {
    private final BankService bankService;
    
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/nuevo")
    public String formularioNuevoBanco(Model model){
        model.addAttribute("banco", new Bank());
        return "bancos/form-banco";
    }

    @PostMapping("/guardar")
    public String guardarBanco(@ModelAttribute("banco") Bank bank){
        bankService.guardar(bank);
        return "redirect:/";

    }

}
