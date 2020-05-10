package com.mycompany.aulaspring3.controller;

import com.mycompany.aulaspring3.dao.ClienteRepository;
import com.mycompany.aulaspring3.dao.SupermercadoRepository;
import com.mycompany.aulaspring3.model.Cliente;
import com.mycompany.aulaspring3.model.Supermercado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SupermercadoController {

    private SupermercadoRepository repository;
    private ClienteRepository clienteRepository;

    public SupermercadoController(SupermercadoRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @RequestMapping({"/supermercado","/supermercado/index"})
    public String index(Model model) {

        List<Supermercado> mercados = this.repository.findAll();

        model.addAttribute("mercados", mercados);

        return "supermercado/index";
    }

    @RequestMapping("/supermercado/inserir")
    public String inserir(Model model){

        Supermercado supermercado = new Supermercado();
        model.addAttribute("supermercado", supermercado);
        return "/supermercado/inserir";

    }

    @RequestMapping(value = "/supermercado/inserirAction", method = RequestMethod.POST)
    public String inserirAction(@ModelAttribute("supermercado") Supermercado supermercado,
                                BindingResult result,
                                ModelMap model){

        this.repository.save(supermercado);

        return "redirect:../supermercado/";
    }

    @RequestMapping("/supermercado/clientes")
    public String clientes(Model model) {

        List<Cliente> clientes = this.clienteRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "cliente/listar";
    }

}
