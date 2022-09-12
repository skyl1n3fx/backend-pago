package com.banco.banco.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.banco.models.AccountModel;
import com.banco.banco.repositories.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public ArrayList<AccountModel> listAccounts(){
        return (ArrayList<AccountModel>) accountRepository.findAll();
    }

    public AccountModel createAccount(AccountModel account){
        return accountRepository.save(account);
    }

    public Optional<AccountModel>retrieveAccountById(Long id){
        return accountRepository.findById(id);
    }

    public ArrayList<AccountModel> retrieveAccountByNum(String num){
        return accountRepository.findByNumeroCuenta(num);
    }

    public boolean deleteAccount(Long id){
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AccountModel pago(String numAccount, Integer pago){
        ArrayList<AccountModel> lista = this.retrieveAccountByNum(numAccount);
        AccountModel cuenta = lista.get(0);
        cuenta.setSaldo(cuenta.getSaldo()-pago);
        return accountRepository.save(cuenta);
    }

}
