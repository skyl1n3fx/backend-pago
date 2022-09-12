package com.banco.banco.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class AccountModel {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    private String numeroCuenta;
    private String cvv;
    private Date fechaVencimiento;
    private Integer saldo;


    // Getters y Setters

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setNumeroCuenta(String nCuenta){
        this.numeroCuenta = nCuenta;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public void setCvv(String cvv){
        this.cvv = cvv;
    }

    public String getCvv(){
        return cvv;
    }

    public void setFechaVencimiento(Date fecha){
        this.fechaVencimiento = fecha;
    }

    public Date getFechaVencimiento(){
        return fechaVencimiento;
    }

    public void setSaldo(Integer saldo){
        this.saldo = saldo;
    }

    public Integer getSaldo(){
        return saldo;
    }

}
