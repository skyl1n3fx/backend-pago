package com.banco.banco.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.models.AccountModel;
import com.banco.banco.models.PayModel;
import com.banco.banco.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping()
    public ArrayList<AccountModel> listAccounts(){
        return accountService.listAccounts();
    }

    @PostMapping()
    public AccountModel createAccount(@RequestBody AccountModel account ){
        return this.accountService.createAccount(account);
    }

    @GetMapping(path="/{id}")
    public Optional<AccountModel> retrieveAccountById(@PathVariable("id") Long id) {
        return this.accountService.retrieveAccountById(id);
    }

    @GetMapping("/query")
    public ArrayList<AccountModel> retrieveAccountByNum(@RequestParam("numeroCuenta") String numeroCuenta) {
        return this.accountService.retrieveAccountByNum(numeroCuenta);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAccount(@PathVariable("id") Long id){
        boolean flag = this.accountService.deleteAccount(id);
        if(flag){
            return "Se eliminó la cuenta con el ID " + id;
        }else{
            return "No se pudo eliminar la cuenta con el ID" + id;
        }
    }

    

    @PostMapping("/pago")
    public ResponseEntity<Object> postBody(@RequestBody PayModel pay){ 
        Map<String, Object> map = new HashMap<>();
        
        int response = this.accountService.pago(pay.getNumeroCuenta(), pay.getTotal());
        if(response == 1){
            map.put("message", "Pago realizado con éxito.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else if(response == 2){
            map.put("message", "No cuenta con saldo suficiente.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else if(response == 3){
            map.put("error", "La tarjeta no existe.");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        map.put("error", "No se pudo realizar la operación");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    
    }

}
