package com.eatMore.controller;

import com.eatMore.dto.ItemDTO;
import com.eatMore.dto.ShopItem;
import com.eatMore.entity.Item;
import com.eatMore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item")
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/item/{id}")
    public ItemDTO getItem(@PathVariable("id") Integer id){
        return itemService.getItem(id);
    }

    @PostMapping(value = "/item", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveItem(@RequestParam("file") MultipartFile file, @RequestPart("item") ItemDTO itemDTO ) throws IOException {
            System.out.println("Hello..");
            System.out.println(file.getBytes());
//            System.out.println(dto.getItemName());
           // itemService.saveItem(dto);
            return ResponseEntity.ok("Success");

    }

    @DeleteMapping(value = "/item/{id}")
    public void deleteItem(@PathVariable("id") Integer id){
        itemService.deleteItem(id);
    }

    @PutMapping(value = "/item")
    public void updateItem(@RequestBody ItemDTO dto){
        itemService.updateItem(dto);
    }

    @GetMapping(value = "/getShopItems/{id}")
    public List<Item> getShopItems(@PathVariable("id") Integer id){
        System.out.println("Hello");
        return itemService.getShopItem(id);
    }
}
