package com.eatMore.repository;

import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    //@Query("SELECT new com.eatMore.dto.ShopItem(i.item_name,i.item_price) FROM Item i WHERE i.shopid = ")
    //List<ShopItem> getShopItems(Integer id);
//      Working
//        @Query("SELECT new com.eatMore.entity.Item(i.id,i.name,i.price) FROM  Item  i WHERE i.shopid = 2")
//        List<Item> getShopItems();


        @Query("SELECT new com.eatMore.entity.Item(i.id,i.name,i.price) FROM  Item  i  INNER JOIN Shop s ON i.id = s.s")
        List<Item> getShopItems(Integer id);
}
