package com.mycompany.aulaspring3.model;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String senha;
    @OneToOne(mappedBy = "cliente", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Carrinho carrinho;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
        carrinho.setCliente(this);
    }

    public float getValorTotal() {
        return this.getCarrinho().getValorTotal();
    }

    public float pagar(Pagamento pagamento) {
        float valorPago = this.getValorTotal() + pagamento.getTaxa();
        //this.getCarrinho().getPedidos();
        //System.out.println(String.format("CLIENTE: %s\nR$%.2f PAGO no %s",this.getNome(),valorPago,pagamento.getNome()));
        return valorPago;
    }
}
