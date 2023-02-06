/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.service;

import com.codeweb.pojos.product;
import com.codeweb.pojos.productInShop;
import java.util.List;

/**
 *
 * @author KHOA
 */
public interface ProductInShopService {
    List<productInShop> getProducts(String kw, int page);
    List<productInShop> getAllProducts();
    boolean addOrUpdate(productInShop product);
    long countProduct();
}
