/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.repository.implement;

import com.codeweb.pojos.person;
import com.codeweb.pojos.product;
import com.codeweb.repository.PersonRepository;
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

/**
 *
 * @author KHOA
 */
@Repository
@Transactional
public class PersonRepositoryImp  implements PersonRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<person> getAllPersons() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From person");
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> getFieldsOfPerson() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select p.userID, p.fullName, p.password from person p");
        
        return q.getResultList();
    }

    @Override
    public List<person> getPersonByName(String name1, String name2) {
        //Get Session
        Session session = sessionFactory.getObject().getCurrentSession();
        
        //Create builder from session
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        //Create criteria query
        CriteriaQuery<person> query = builder.createQuery(person.class);
        
        //Create root which get all person
        Root root = query.from(person.class);
        
        //Apply root into query
        query = query.select(root);
        
        //Create 2 prdicate (a part of the query statement) using condition "like"
        Predicate p1 = builder.like(root.get("fullName").as(String.class), new String("%" + name1 + "%"));
        Predicate p2 = builder.like(root.get("fullName").as(String.class), new String("%" + name2 + "%"));
        
        //Apply (gan them cau vao chuoi truy van) 2 prediacte into query using where
        query = query.where(builder.or(p1, p2));
        
        //Create a executable query from the data of criteria query
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Object[] getCountMax() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root root = query.from(person.class);
        query = query.multiselect(builder.count(root.get("userID").as(String.class)),
                builder.max(root.get("age").as(Integer.class)));
        Query q = session.createQuery(query);
        
        return (Object[]) q.getSingleResult();
    }

    @Override
    public List<Object[]> statisticalQuery() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<product> productRoot = query.from(product.class);
        Root<person> personRoot = query.from(person.class);
        query.where(builder.equal(productRoot.get("person"), personRoot.get("userID")));
        query.multiselect(personRoot.get("fullName").as(String.class),
                builder.count(productRoot.get("productID").as(String.class)),
                builder.max(productRoot.get("price").as(Integer.class)));
        query = query.groupBy(personRoot.get("fullName").as(String.class));
        query = query.orderBy(builder.asc(personRoot.get("fullName").as(String.class)));
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<person> getPerson(String userID) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        //Create builder from session
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        //Create criteria query
        CriteriaQuery<person> query = builder.createQuery(person.class);
        
        //Create root which get all person
        Root root = query.from(person.class);
        
        //Apply root into query
        query = query.select(root);
        
        //Create 2 prdicate (a part of the query statement) using condition "like"
        Predicate p1 = builder.like(root.get("userID").as(String.class), new String("%" + userID + "%"));
        query = query.where(p1);
        
        //Create a executable query from the data of criteria query
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
    
    
    
}
