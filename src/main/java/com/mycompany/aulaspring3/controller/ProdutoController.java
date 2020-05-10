package com.mycompany.aulaspring3.controller;

import com.mycompany.aulaspring3.dao.ProdutoRepository;
import com.mycompany.aulaspring3.model.Pagamento;
import com.mycompany.aulaspring3.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping({"/produto","/produto/index"})
    public String index(Model model) {

        List<Produto> produtos = this.repository.findAll();
        produtos.sort(Comparator.comparing(Produto::getId));
        model.addAttribute("produtos", produtos);

        return "/produto/index";
    }

    @RequestMapping("/produto/inserir")
    public String inserir(Model model){

        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        return "/produto/inserir";

    }

    @RequestMapping(value = "/produto/inserirAction", method = RequestMethod.POST)
    public String inserirAction(@ModelAttribute("produto") Produto produto,
                                BindingResult result,
                                ModelMap model){
        if(result.hasErrors() || produto.getMarca() == "" || produto.getTipo() == "") {
            return "/produto/error";
        }
        List<Produto> produtos = this.repository.findAll();
        produtos.sort(Comparator.comparing(Produto::getId));
        int lastID = 0;
        for (Produto p : produtos) {
            if (lastID < p.getId()) {
                lastID = p.getId();
            }
        }
        produto.setId(lastID+1);
        produto.setUltimoRestoque(new Date());
        this.repository.save(produto);
        model.addAttribute("produto", produto);
        //SupermercadoDao.getSupermercado().getEstoque().addProdutoEmEstoque(produto.getTipo(),produto.getMarca(),produto.getValor(),produto.getQuantidadeEstoque(),String.valueOf(produtos.size()+1));
        //return "/produto/index";
        return "redirect:../produto/index";
    }

    @RequestMapping("/produto/remover")
    public String remover(Model model, @RequestParam("id") int id){

        Produto produto = null;
        for (Produto item: this.repository.findAll()) {
            if (item.getId() == id) {
                produto = item;
            }
        }

        this.repository.delete(produto);
        return "/produto/visualizar";

    }

    @RequestMapping({"/estoque","/estoque/index"})
    public String estoque(Model model) {

        List<Produto> produtos = this.repository.findAll();
        produtos.sort(Comparator.comparing(Produto::getId));
        model.addAttribute("produtos", produtos);

        return "/estoque/index";
    }

    @RequestMapping("/produto/alterar")
    public String alterar(Model model, @RequestParam("id") int id){

        Produto produto = this.repository.getOne(id);
        model.addAttribute("produto", produto);

        return "produto/alterar";

    }

    @RequestMapping(value = "/produto/alterarAction", method = RequestMethod.POST)
    public String alterarAction(@ModelAttribute("produto") Produto produto, BindingResult result){
        if(result.hasErrors() || produto.getMarca() == "" || produto.getTipo() == "") {
            return "/produto/error";
        }
        produto.setUltimoRestoque(new Date());
        this.repository.save(produto);

        return "redirect:../produto";
    }

}
