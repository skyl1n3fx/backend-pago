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

    public String pago(String numAccount, Integer total){
        try {
            System.out.println("Número de cuenta es " + numAccount);
            ArrayList<AccountModel> lista = this.retrieveAccountByNum(numAccount);
            System.out.println("Cantidad de cuentas " + lista.size());
            AccountModel cuenta = lista.get(0);
            if(cuenta.pagar(total)){
                accountRepository.save(cuenta);
                return "Se realizó el pago con éxito";
            }
            return "No tiene saldo suficiente";   
        } catch (Exception e) {
            return "La cuenta no existe";
        }
    }

}
