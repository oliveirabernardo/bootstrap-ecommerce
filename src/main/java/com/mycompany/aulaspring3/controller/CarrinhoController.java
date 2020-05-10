package com.mycompany.aulaspring3.controller;

import com.mycompany.aulaspring3.dao.*;
import com.mycompany.aulaspring3.model.Cliente;
import com.mycompany.aulaspring3.model.Pagamento;
import com.mycompany.aulaspring3.model.Pedido;
import com.mycompany.aulaspring3.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CarrinhoController {

    private PedidoRepository repository;
    private ClienteRepository clienteRepository;
    private PagamentoRepository pagamentoRepository;
    private ProdutoRepository produtoRepository;

    public CarrinhoController(PedidoRepository repository, ClienteRepository clienteRepository, PagamentoRepository pagamentoRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.produtoRepository = produtoRepository;
    }

    @RequestMapping("cliente/carrinho")
    public String carrinho(HttpSession session, Model model) {

        List<Pedido> pedidos = this.repository.findAll();
        int id = (int) session.getAttribute("id");
        pedidos.removeIf(pedido -> pedido.getCarrinho().getCliente().getId() != id);

        model.addAttribute("items", pedidos);

        return "/cliente/carrinho";
    }

    @RequestMapping("/cliente/comprar")
    public String comprar(HttpSession session, @RequestParam("id") int id){
        Cliente c = null;
        for (Cliente cliente : this.clienteRepository.findAll()) {
            if (session.getAttribute("id").equals(cliente.getId())) {
                c = cliente;
            }
        }

        List<Pedido> itemsCarrinho = this.repository.findAll();
        List<Produto> estoque = this.produtoRepository.findAll();
        int index = (int) session.getAttribute("id");
        itemsCarrinho.removeIf(pedido -> pedido.getCarrinho().getCliente().getId() != index);

        Produto produto = null;
        Pedido pedido = null;
        boolean found = false;
        for (Pedido i : itemsCarrinho) {
            if (i.getProduto().getId() == id) {
                pedido = i;
                pedido.addQuantidade(1);
                pedido.getProduto().diminuirQuantidadeEstoque(1);
                found = true;
            }
        }
        for (Produto p : estoque) {
            if (p.getId() == id) {
                produto = p;
            }
        }
        if (!found) {
            pedido = new Pedido(c.getCarrinho(), produto);
            //pedido = new Pedido(c.getCarrinho(), SupermercadoDao.getSupermercado().getEstoque().getProduto(id));
            pedido.addQuantidade(1);
            pedido.getProduto().diminuirQuantidadeEstoque(1);
        }
        //c.getCarrinho().addItem(SupermercadoDao.getSupermercado().getEstoque().getProduto(id));
        //SupermercadoDao.getSupermercado().getEstoque().pegarProduto(c.getCarrinho() ,id);
        this.repository.save(pedido);
        return "redirect:../cliente/carrinho";

    }

    @RequestMapping("/carrinho/remover")
    public String remover(HttpSession session, Model model, @RequestParam("id") int id){

        Cliente c = null;
        for (Cliente cliente : this.clienteRepository.findAll()) {
            if (session.getAttribute("id").equals(cliente.getId())) {
                c = cliente;
            }
        }

        Pedido pedido = this.repository.getOne(c.getCarrinho().getItem(id).getId());
        if (pedido.getQuantidade() > 1) {
            pedido.diminuirQuantidade(1);
            this.repository.save(pedido);
        } else {
            this.repository.delete(pedido);
        }
        return "redirect:../cliente/carrinho";

    }

    @RequestMapping("cliente/finalizar")
    public String finalizar(Model model) {

        List<Pagamento> pagamentoList = this.pagamentoRepository.findAll();

        model.addAttribute("pagamento", pagamentoList);

        return "/cliente/finalizar";
    }

}
