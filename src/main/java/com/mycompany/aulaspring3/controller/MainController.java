/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aulaspring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        String mensagem = request.getParameter("mensagem");
        model.addAttribute("mensagem", mensagem);
        return "index/index";
    }
    
}
