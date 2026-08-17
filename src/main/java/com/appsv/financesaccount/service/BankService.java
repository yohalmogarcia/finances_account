package com.appsv.financesaccount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appsv.financesaccount.model.Bank;
import com.appsv.financesaccount.repository.BankRepository;

@Service
public class BankService {
    
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> obtenerTodos(){
        return bankRepository.findAll();
    }

    public Bank guardar(Bank bank){
        return bankRepository.save(bank);
    }

    public Bank obtenerPorId(Integer id){
        return bankRepository.findById(id).orElseThrow(()->new RuntimeException("Banco NO encontrado"));
    }

}
