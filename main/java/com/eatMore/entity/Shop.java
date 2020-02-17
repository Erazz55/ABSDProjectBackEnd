package com.eatMore.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "shops_tbl")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "email", nullable = false)
    private String email;

    @Basic(optional = false)
    @Column(name = "contactNo", nullable = false)
    private String contactNo;

    @Basic(optional = false)
    @Column(name = "contactPersonName", nullable = false)
    private String contactPersonName;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Basic(optional = false)
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(targetEntity = Item.class,mappedBy = "shopid")
    private Collection<Item> itemsCollection;

    public Shop() {
    }

    public Shop(Integer id) {
        this.id = id;
    }

    public Shop(Integer id, String name, String email, String contactNo, String contactPersonName, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPersonName = contactPersonName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Item> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<Item> itemsCollection) {
        this.itemsCollection = itemsCollection;
    }




}
