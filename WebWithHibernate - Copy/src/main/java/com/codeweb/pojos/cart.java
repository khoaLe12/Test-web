/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.pojos;

/**
 *
 * @author KHOA
 */
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblCart")
public class cart implements Serializable{
    @Id
    @Column(name = "cartID")
    private String cartID;
    
    @ManyToOne
    @JoinColumn(name = "userID")
    private person person;

    @OneToMany(mappedBy = "cart")
    private Set<productInShop> productInShops;

    
    
    public Set<productInShop> getProductInShops() {
        return productInShops;
    }

    public void setProductInShops(Set<productInShop> productInShops) {
        this.productInShops = productInShops;
    }
    
    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public person getPerson() {
        return person;
    }

    public void setPerson(person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "cart{" + "cartID=" + cartID + ", person=" + person + '}';
    }
    
    
}
