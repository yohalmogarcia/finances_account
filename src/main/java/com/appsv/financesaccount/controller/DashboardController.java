package com.appsv.financesaccount.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.appsv.financesaccount.model.Bank;
import com.appsv.financesaccount.repository.BankRepository;

@Controller
public class DashboardController {

	private final BankRepository bankRepository;
	
	public DashboardController(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Bank> bancos = bankRepository.findAll();
		
		model.addAttribute("usuarioNombre","LEO");
		model.addAttribute("bancos",bancos);
		
		return "dashboard";
	}
}
