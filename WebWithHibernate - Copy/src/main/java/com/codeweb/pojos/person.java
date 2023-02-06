/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author KHOA
 */
@Entity
@Table(name = "tblUsers")
public class person implements Serializable{
    
    @Id
    @Column(name = "userID")
    private String userID;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "roleID")
    private String roleID;
    @Column(name = "status")
    private boolean status;
    @Column(name = "age")
    private int age;
    
    @OneToMany(mappedBy = "person")
    private Set<product> products;
    
    @OneToMany(mappedBy = "person")
    private Set<cart> carts;

    
    
    public Set<cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<cart> carts) {
        this.carts = carts;
    }
    
    public Set<product> getProducts() {
        return products;
    }

    public void setProducts(Set<product> products) {
        this.products = products;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "person{" + "userID=" + userID + ", fullName=" + fullName + ", password=" + password + ", roleID=" + roleID + ", status=" + status + ", age=" + age + '}';
    }
}
