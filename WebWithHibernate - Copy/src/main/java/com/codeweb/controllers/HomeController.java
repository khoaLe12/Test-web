/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.controllers;

import com.codeweb.pojos.person;
import com.codeweb.pojos.product;
import com.codeweb.service.PersonService;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeweb.service.ProductInShopService;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @author KHOA
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ProductInShopService productInShopService;

    @ModelAttribute
    public void modelAttribute(Model model) {
        model.addAttribute("ALL", this.personService.getAllPersons());
    }

    @RequestMapping("/")
    public String index(Model model,
            //@RequestParam(value = "kw", required = false, defaultValue = "") String kw
            @RequestParam(required = false) Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productInShopService.getProducts(params.getOrDefault("kw",""), page));
        model.addAttribute("counter", this.productInShopService.countProduct());
                
        return "index";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST)
    public String hello(Model model,
            @RequestParam(value = "name1") String name1,
            @RequestParam(value = "name2") String name2) {

        //Truy van toan bo du lieu trong table user dùng cau truy van HQL
        model.addAttribute("ALL", this.personService.getAllPersons()); //Tra ve 1 list danh sach person - user

        //Truy van vai truong thuoc tinh tu bang user
        //Tra ve 1 list danh sach cac thong tin, trong do moi phan tu trong list la 1 mang gom 3 phan tu con tuong ứng: userID, fullName, password
        model.addAttribute("ALL1", this.personService.getFieldsOfPerson());

        //Truy van dung Criteria Query API
        //1. Truy van liet ke danh sach user theo fullname dung lenh "builder.like"
        model.addAttribute("content", this.personService.getPersonByName(name1, name2));

        //2.Truy van lay ra so luong user và lấy ra do tuoi cao nhat trong danh sach
        //Dung lenh builder.count va builder.max
//        Object[] result = (Object[]) q2.getSingleResult();
//        String message = new String("count: " + result[0] + ", max: " + result[1]);
        model.addAttribute("message", this.personService.getCountMax());

        //3.Truy van thong ke theo thu tu tang dan để lay ra so luong product mỗi user có 
        //va giá tien product lon nhat cua user do
        //Xay dung 2 root tuong duong voi 2 table de join dung lenh builder.equal
        model.addAttribute("MESSGAE", this.personService.statisticalQuery());

        return "hello";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        return "cart";
    }
}
