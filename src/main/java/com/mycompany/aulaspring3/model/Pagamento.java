package com.mycompany.aulaspring3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float taxa;

    public Pagamento(String nome, float taxa) {
        this.setTaxa(taxa);
        this.setNome(nome);
    }

    public Pagamento() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float getTaxa() {
        return taxa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
