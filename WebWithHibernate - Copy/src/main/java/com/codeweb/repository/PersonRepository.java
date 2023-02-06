/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.repository;

import com.codeweb.pojos.person;
import java.util.List;

/**
 *
 * @author KHOA
 */
public interface PersonRepository {
    List<person> getAllPersons();
    List<Object[]> getFieldsOfPerson();
    List<person> getPersonByName(String name1, String name2);
    Object[] getCountMax();
    List<Object[]> statisticalQuery();
    List<person> getPerson(String userID);
    
}
