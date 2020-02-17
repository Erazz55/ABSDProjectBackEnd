package com.eatMore.service;

import com.eatMore.dto.ItemDTO;
import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    List<ItemDTO> getAllItems();

    ItemDTO getItem(Integer id);

    void saveItem(ItemDTO dto);

    void deleteItem(Integer id);

    void updateItem(ItemDTO dto);

    List<Item> getShopItem(Integer id);
}
