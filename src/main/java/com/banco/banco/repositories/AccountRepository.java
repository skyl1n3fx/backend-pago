package com.banco.banco.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banco.banco.models.AccountModel;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long>{
    public abstract ArrayList<AccountModel> findByNumeroCuenta(String numeroCuenta);

    @Query(value = "SELECT * FROM cuenta_bancaria c WHERE c.numero_cuenta = :num AND c.nombre_titular = :name AND c.cvv = :cvv AND fecha_expiracion = :date", 
    nativeQuery = true)
    public abstract AccountModel findAccountPay(@Param("num") String num, @Param("name") String nombre, @Param("cvv") String cvv, @Param("date") String fecha);
    
}

// @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
