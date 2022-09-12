package com.banco.banco.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.banco.models.AccountModel;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long>{
    public abstract ArrayList<AccountModel> findByNumeroCuenta(String numeroCuenta);
}
