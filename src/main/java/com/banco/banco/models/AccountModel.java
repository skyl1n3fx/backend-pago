package com.banco.banco.models;
import javax.persistence.*;

@Entity
@Table(name = "cuenta_bancaria")
public class AccountModel {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroCuenta;

    @Column(unique = true, nullable = true)
    private String rut;

    @Column(unique = true, nullable = true)
    private String pasaporte;

    private String nombreTitular;
    private String cvv;
    private String fechaExpiracion;
    private Integer saldo;


    // Getters y Setters

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setNombreTitular(String nombre){
        this.nombreTitular = nombre.toUpperCase();
    }

    public String getNombreTitular(){
        return this.nombreTitular;
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

    public void setFechaExpiracion(String fecha){
        this.fechaExpiracion = fecha;
    }

    public String getFechaExpiracion(){
        return fechaExpiracion;
    }

    public void setSaldo(Integer saldo){
        this.saldo = saldo;
    }

    public Integer getSaldo(){
        return saldo;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public String getRut(){
        return this.rut;
    }

    public void setPasaporte(String pasaporte){
        this.pasaporte = pasaporte;
    }

    public String getPasaporte(){
        return this.pasaporte;
    }

    // Método customer que aplica el pago
    public boolean pagar(Integer total){
        boolean flag = false;
        // Validamos si tiene saldo suficiente
        if(this.saldo >= total){
            this.saldo = this.saldo - total;
            flag = true;
        }
        return flag;
    }
    
}
