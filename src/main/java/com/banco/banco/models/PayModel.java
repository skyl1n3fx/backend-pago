package com.banco.banco.models;

public class PayModel {
    private String numeroCuenta;
    private Integer total;

    public void setNumeroCuenta(String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public void setTotal(Integer total){
        this.total = total;
    }

    public Integer getTotal(){
        return this.total;
    }
}
