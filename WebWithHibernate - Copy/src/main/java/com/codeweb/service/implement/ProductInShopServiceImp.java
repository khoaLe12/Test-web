/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.service.implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.codeweb.pojos.product;
import com.codeweb.pojos.productInShop;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeweb.repository.ProductinShopRepository;
import com.codeweb.service.ProductInShopService;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author KHOA
 */
@Service
public class ProductInShopServiceImp implements ProductInShopService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductinShopRepository productInShopRepository;

    @Override
    public List<productInShop> getProducts(String kw, int page) {
        return this.productInShopRepository.getProducts(kw, page);
    }

    @Override
    public List<productInShop> getAllProducts() {
        return this.productInShopRepository.getAllProducts();
    }

    @Override
    public boolean addOrUpdate(productInShop product) {
        try {
            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            product.setImage((String) r.get("secure_url"));
            
            return this.productInShopRepository.addOrUpdate(product);
        } catch (IOException e) {
            System.err.println("==ADD PRODUCT==" + e.getMessage());
        }
        return false;
    }

    @Override
    public long countProduct() {
        return this.productInShopRepository.countProduct();
    }

}
