/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.model;

import java.util.Date;

/**
 *
 * @author FLOPEZ
 */
public class Vale implements java.io.Serializable{
     private int id;
     private String cliente;
     private String numero;
     private String producto;
     private Double monto;
     private String chofer;
     private String placa;
     private Date fecha;
     private Integer estado;

    public Vale() {
    }

    public Vale(int id, String cliente, String vale, String producto, Double monto, String chofer, String placa, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.numero = vale;
        this.producto = producto;
        this.monto = monto;
        this.chofer = chofer;
        this.placa = placa;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVale() {
        return numero;
    }

    public void setVale(String vale) {
        this.numero = vale;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
