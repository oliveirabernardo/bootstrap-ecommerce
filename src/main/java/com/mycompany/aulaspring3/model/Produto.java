package com.mycompany.aulaspring3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String marca;
    private float valor;
    private Date ultimoRestoque;
    private int quantidadeEstoque;

    public Produto(String tipo, String marca, float valor, int quantidade, int codigo) {
        this.setTipo(tipo);
        this.setMarca(marca);
        this.setValor(valor);
        this.setQuantidadeEstoque(quantidade);
    }

    public Produto() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUltimoRestoque() {
        return ultimoRestoque;
    }

    public void setUltimoRestoque(Date ultimoRestoque) {
        this.ultimoRestoque = ultimoRestoque;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void setQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque = quantidade;
    }

    public void diminuirQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

}

