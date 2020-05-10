package com.mycompany.aulaspring3.dao;

import com.mycompany.aulaspring3.model.Carrinho;
import com.mycompany.aulaspring3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

}
