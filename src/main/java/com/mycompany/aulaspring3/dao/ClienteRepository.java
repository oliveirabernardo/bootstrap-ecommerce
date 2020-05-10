package com.mycompany.aulaspring3.dao;

import com.mycompany.aulaspring3.model.Cliente;
import com.mycompany.aulaspring3.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
