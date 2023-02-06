/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.service.implement;

import com.codeweb.pojos.person;
import com.codeweb.repository.PersonRepository;
import com.codeweb.service.PersonService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author KHOA
 */
@Service("userDetailsService")
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public List<person> getAllPersons() {
        return this.personRepository.getAllPersons();
    }

    @Override
    public List<Object[]> getFieldsOfPerson() {
        return this.personRepository.getFieldsOfPerson();
    }

    @Override
    public List<person> getPersonByName(String name1, String name2) {
        return this.personRepository.getPersonByName(name1, name2);
    }

    @Override
    public Object[] getCountMax() {
        return this.personRepository.getCountMax();
    }

    @Override
    public List<Object[]> statisticalQuery() {
        return this.personRepository.statisticalQuery();
    }

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        List<person> persons = this.getPerson(userID);
        if(persons.isEmpty()){
            throw new UsernameNotFoundException("User does not exist");
        }
        person person = persons.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(person.getRoleID()));
        
        return new org.springframework.security.core
                .userdetails.User(person.getUserID(), person.getPassword(), auth);
    }

    @Override
    public List<person> getPerson(String userID) {
        return this.personRepository.getPerson(userID);
    }
    
}
