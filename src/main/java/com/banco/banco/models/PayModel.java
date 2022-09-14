package com.banco.banco.models;

public class PayModel {
    private String numeroCuenta;
    private String titular;
    private String fechaExpiracion;
    private String cvv;
    private Integer total;

    public void setTitular(String nombre){
        this.titular = nombre.toUpperCase();
    }

    public String getTitular(){
        return this.titular;
    }

    public void setCvv(String cvv){
        this.cvv = cvv;
    }

    public String getCvv(){
        return cvv;
    }

    public void setFechaExpiracion(String fecha){
        this.fechaExpiracion = fecha;
    }

    public String getFechaExpiracion(){
        return fechaExpiracion;
    }

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

    public String toString(){
        return "Numero de cuenta " + this.numeroCuenta + " CVV " + this.cvv + " TITULAR " + this.titular + " FECHA EXPIRACIÓN " + this.fechaExpiracion;
    }
}
