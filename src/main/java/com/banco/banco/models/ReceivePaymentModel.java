package com.banco.banco.models;

public class ReceivePaymentModel {
    private String numeroCuenta;
    private Integer monto;

    public void setNumeroCuenta(String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }

    public void setMonto(Integer monto){
        this.monto = monto;
    }

    public String getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public Integer getMonto(){
        return this.monto;
    }

    public String toString(){
        return "Numero de cuenta : " + this.numeroCuenta + " " + " Monto : " + this.monto;
    }
}
