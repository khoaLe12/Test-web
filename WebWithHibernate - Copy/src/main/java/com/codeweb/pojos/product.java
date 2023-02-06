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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "tblProducts")
public class product implements Serializable{
    @Id
    @Column(name = "productID")
    private String productID;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private int price;
    
    @Column(name = "image")
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "userID")
    private person person;
    
    @Transient
    private MultipartFile file;
    
    
    public person getPerson() {
        return person;
    }

    public void setPerson(person person) {
        this.person = person;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    
}
