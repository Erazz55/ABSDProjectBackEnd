package com.eatMore.service.impl;

import com.eatMore.dto.ShopDTO;
import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Shop;
import com.eatMore.repository.ItemRepository;
import com.eatMore.repository.ShopRepository;
import com.eatMore.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;


    @Override
    public List<ShopDTO> getAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                .map(c-> new ShopDTO(c.getId(), c.getName(), c.getEmail(), c.getContactNo(), c.getContactPersonName()))
                .collect(Collectors.toList());
    }


}
