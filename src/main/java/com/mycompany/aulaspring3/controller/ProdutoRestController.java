package com.mycompany.aulaspring3.controller;

import com.mycompany.aulaspring3.dao.ProdutoRepository;
import com.mycompany.aulaspring3.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/produto")
public class ProdutoRestController {

    private ProdutoRepository repository;

    public ProdutoRestController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Produto> list() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable int id) {
        Produto produto = this.repository.getOne(id);
        if (produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @RequestBody Produto newProduto) {
        Produto oldProduto = this.repository.getOne(id);
        if (oldProduto != null) {
            newProduto.setId(id);
            this.repository.save(newProduto);
            return new ResponseEntity<>(newProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Produto post(@RequestBody Produto produto) {
        produto.setId((int) this.repository.count());
        return this.repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Produto produto = this.repository.getOne(id);
        if (produto != null) {
            this.repository.delete(produto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
