package com.eatMore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "items_tbl")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic(optional = false)
    @Column(name = "price", nullable = false, length = 45)
    private String price;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @JoinColumn(name = "shopid", referencedColumnName = "id")
    @ManyToOne
    private Shop shopid;

//    @Column(name = "shopid")
//    private Integer shopId;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(String name, String price, byte[] image, Shop shopid) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.shopid = shopid;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Shop getShopid() {
        return shopid;
    }

    public void setShopid(Shop shopid) {
        this.shopid = shopid;
    }

    public Shop getShopId() {
        return shopid;
    }

    public void setShopId(Shop shopid) {
        this.shopid = shopid;
    }
}

