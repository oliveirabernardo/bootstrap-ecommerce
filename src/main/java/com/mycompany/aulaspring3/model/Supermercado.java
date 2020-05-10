package com.mycompany.aulaspring3.model;

import com.mycompany.aulaspring3.dao.ClienteRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supermercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Supermercado() {
    }

    public int getId() {
        return id;
    }

}
