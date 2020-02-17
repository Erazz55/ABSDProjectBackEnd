package com.eatMore.service.impl;

import com.eatMore.dto.ShopSignUpDTO;
import com.eatMore.entity.Shop;
import com.eatMore.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtShopDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Shop shop = shopRepository.findShopByEmail(email);

        if(shop == null){
            throw new UsernameNotFoundException("Shop not found with email" + email);
        }

        return new org.springframework.security.core.userdetails.User(shop.getEmail(),shop.getPassword(), new ArrayList<>());
    }

    public Shop getShop(String email){
        return shopRepository.findShopByEmail(email);
    }



    public String saveShop(ShopSignUpDTO dto){
        Shop shop = new Shop();
        shop.setName(dto.getName());
        shop.setEmail(dto.getEmail());
        shop.setContactNo(dto.getContactNo());
        shop.setContactPersonName(dto.getContactPersonName());
        shop.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        shopRepository.save(shop);
        return "Success";
    }
}
