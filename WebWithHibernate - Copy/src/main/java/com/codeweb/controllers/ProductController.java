/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.codeweb.pojos.productInShop;
import com.codeweb.service.ProductInShopService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author KHOA
 */
@Controller
public class ProductController {

    @Autowired
    private ProductInShopService productInShopService;

    @GetMapping("/admin/products")
    public String list(Model model) {
        model.addAttribute("product", new productInShop());
        return "product";
    }

    @PostMapping("/admin/products")
    public String add(Model model, @ModelAttribute(value = "product") productInShop product) {
        if(this.productInShopService.addOrUpdate(product) == true)
            return "redirect:/";
        else{ 
            model.addAttribute("errMsg","Something wrong!!!");
            return "product";
        }
    }
}
