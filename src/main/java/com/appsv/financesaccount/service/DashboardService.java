package com.appsv.financesaccount.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appsv.financesaccount.model.Bank;
import com.appsv.financesaccount.repository.BankRepository;

@Service
public class DashboardService {

	private final BankRepository bankRepository;
	
	public DashboardService(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
	
	public List<Bank> obtenerTodosLosBancos(){
		return bankRepository.findAll();
	}
	
	public BigDecimal calcularBalanceTotal(List<Bank> bancos) {
		return bancos.stream()
				.flatMap(bank -> bank.getCategoryList().stream())
				.map(cat -> cat.getActualBalance())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
