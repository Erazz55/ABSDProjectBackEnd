package com.eatMore.service.impl;

import com.eatMore.dto.ItemDTO;
import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Item;
import com.eatMore.entity.Shop;
import com.eatMore.repository.ItemRepository;
import com.eatMore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(c->new ItemDTO(c.getName(),c.getPrice()))
                .collect(Collectors.toList());
    }



    @Override
    public ItemDTO getItem(Integer id) {
        Item item = itemRepository.findById(id).get();
        return new ItemDTO(item.getName(), item.getPrice());
    }

    @Override
    public void saveItem(ItemDTO dto) {
        Item item = new Item();
        Shop shop = new Shop(dto.getShopId());

        item.setName(dto.getItemName());
        item.setPrice(dto.getItemPrice());
        item.setShopId(shop);

        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(ItemDTO dto) {
//        itemRepository.save(new Item(dto.getItemName(),dto.getItemPrice()));
    }

    @Override
    public List<Item> getShopItem(Integer id) {
        return itemRepository.getShopItems(id);

    }
}
