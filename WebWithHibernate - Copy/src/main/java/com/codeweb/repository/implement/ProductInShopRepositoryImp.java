/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.repository.implement;

import com.codeweb.pojos.product;
import com.codeweb.pojos.productInShop;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.codeweb.repository.ProductinShopRepository;

/**
 *
 * @author KHOA
 */
@Repository
@Transactional
public class ProductInShopRepositoryImp implements ProductinShopRepository{

    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<productInShop> getProducts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<productInShop> query = builder.createQuery(productInShop.class);
        Root root = query.from(productInShop.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw!=null){
            Predicate p = builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public List<productInShop> getAllProducts() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From productInShop");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(productInShop product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);
            return true;
        } catch (Exception e) {
            System.err.println("== ADD PRODUCT ERROR ==" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM productInShop");
        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
}
