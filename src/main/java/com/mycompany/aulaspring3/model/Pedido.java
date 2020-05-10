package com.mycompany.aulaspring3.model;

import javax.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Carrinho carrinho;
    @ManyToOne
    private Produto produto;
    private int quantidade;

    public Pedido(Carrinho carrinho, Produto produto) {
        this.carrinho = carrinho;
        carrinho.addPedido(this);
        this.produto = produto;
    }

    public Pedido() {

    }

    public int getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void addQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }


    public void diminuirQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }
}
