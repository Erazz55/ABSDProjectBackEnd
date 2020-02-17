package com.eatMore.repository;


import com.eatMore.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    Shop findShopByEmail(String email);

//    @Query("SELECT new com.eatMore.dto.ShopItem(i.item_name,i.item_price)"
//            + "FROM shops_tbl s INNER JOIN items_tbl i ON s.shop_id = i.item_shopid WHERE s.shop_id = ?1")
//    List<ShopItem> getShopItems(Integer id);

}
