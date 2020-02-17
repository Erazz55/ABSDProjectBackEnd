package com.eatMore.service;

import com.eatMore.dto.ShopDTO;
import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Shop;

import java.util.List;

public interface ShopService {

    List<ShopDTO> getAllShops();
}
