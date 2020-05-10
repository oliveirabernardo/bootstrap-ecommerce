package com.mycompany.aulaspring3.dao;

import com.mycompany.aulaspring3.model.Produto;
import com.mycompany.aulaspring3.model.Supermercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer> {

}
