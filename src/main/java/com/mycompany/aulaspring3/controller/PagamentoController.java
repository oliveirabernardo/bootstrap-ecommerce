package com.mycompany.aulaspring3.controller;

import com.mycompany.aulaspring3.dao.ClienteRepository;
import com.mycompany.aulaspring3.dao.PagamentoRepository;
import com.mycompany.aulaspring3.dao.PedidoRepository;
import com.mycompany.aulaspring3.dao.ProdutoRepository;
import com.mycompany.aulaspring3.model.Cliente;
import com.mycompany.aulaspring3.model.Pagamento;
import com.mycompany.aulaspring3.model.Pedido;
import com.mycompany.aulaspring3.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class PagamentoController {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private PagamentoRepository repository;

    public PagamentoController(PagamentoRepository repository, ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @RequestMapping("/supermercado/pagamento")
    public String index(Model model) {

        List<Pagamento> formasPagamento = this.repository.findAll();
        model.addAttribute("formasPagamento", formasPagamento);

        return "pagamento/index";
    }

    @RequestMapping("/supermercado/pagamento/inserir")
    public String inserir(Model model){

        Pagamento pagamento = new Pagamento();
        model.addAttribute("pagamento", pagamento);
        return "pagamento/inserir";

    }

    @RequestMapping(value = "/supermercado/pagamento/inserirAction", method = RequestMethod.POST)
    public String inserirAction(@ModelAttribute("pagamento") Pagamento pagamento,
                                BindingResult result,
                                ModelMap model){
        if(result.hasErrors() || pagamento.getNome() == "" || pagamento.getTaxa() == 0) {
            return "/produto/error";
        }

        this.repository.save(pagamento);
        model.addAttribute("pagamento", pagamento);
        return "redirect:../pagamento";
    }

    @RequestMapping("/supermercado/pagamento/remover")
    public String remover(@RequestParam("id") int id){

        this.repository.deleteById(id);

        return "redirect:../pagamento";

    }

    @RequestMapping("/supermercado/pagamento/alterar")
    public String alterar(Model model, @RequestParam("id") int id){

        Pagamento pagamento = this.repository.getOne(id);
        model.addAttribute("pagamento", pagamento);

        return "pagamento/alterar";

    }

    @RequestMapping(value = "/supermercado/pagamento/alterarAction", method = RequestMethod.POST)
    public String alterarAction(@ModelAttribute("pagamento") Pagamento pagamento, BindingResult result){
        if(result.hasErrors() || pagamento.getNome() == "" || pagamento.getTaxa() == 0) {
            return "/produto/error";
        }

        this.repository.save(pagamento);

        return "redirect:../pagamento";
    }

    @RequestMapping("/cliente/pedido")
    public String pedido(HttpSession session, Model model, @RequestParam("id") int id){

        List<Pedido> pedido = this.pedidoRepository.findAll();
        Cliente cliente = this.clienteRepository.getOne((int)session.getAttribute("id"));
        Pagamento pagamento = this.repository.getOne(id);
        float pago = cliente.pagar(pagamento);

        for (Pedido p : pedido) {
            if (p.getCarrinho().getCliente().equals(cliente)) {
                this.pedidoRepository.delete(p);
            }
        }

        model.addAttribute("valor", pago);
        model.addAttribute("pagamento",pagamento);



        return "pagamento/sucesso";

    }
}
