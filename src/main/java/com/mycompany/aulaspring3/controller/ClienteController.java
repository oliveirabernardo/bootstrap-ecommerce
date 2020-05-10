/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aulaspring3.controller;


import com.mycompany.aulaspring3.dao.ClienteRepository;
import com.mycompany.aulaspring3.model.Carrinho;
import com.mycompany.aulaspring3.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("username")
public class ClienteController {

    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }
    
    @RequestMapping(value = "cliente/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            ModelMap modelMap) {
        List<Cliente> clientes = this.repository.findAll();

        for (Cliente c : clientes) {
            if (username.equals(c.getNome()) && password.equals(c.getSenha())) {
                session.setAttribute("id", c.getId());
                return "redirect:../cliente/carrinho";
            }
        }

        if("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)){
            session.setAttribute("id", 1);
            
            return "redirect:../supermercado/";
        }else{
            return "redirect:../?mensagem="+"Login Invalido !";
        }
        
    }

    @RequestMapping("cliente/cadastro")
    public String cadastro(ModelMap modelMap) {

        Cliente cliente = new Cliente();

        modelMap.addAttribute("cliente",cliente);

        return "/cliente/cadastro";

    }

    @RequestMapping(value = "/cliente/cadastroAction", method = RequestMethod.POST)
    public String cadastroAction(@ModelAttribute("cliente") Cliente cliente,
                                BindingResult result,
                                ModelMap model){
        if(result.hasErrors() || cliente.getNome()== "" || cliente.getSenha() == "") {
            return "/produto/error";
        }
        List<Cliente> clientes = this.repository.findAll();

        for (Cliente c : clientes) {
            if (cliente.getNome().equals(c.getNome())) {
                return "redirect:../?mensagem="+"Cliente ja registrado";
            }
        }
        cliente.setCarrinho(new Carrinho());
        model.addAttribute("cliente", cliente);
        this.repository.save(cliente);

        return "index/index";
    }


}
