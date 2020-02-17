package com.eatMore.controller;

import com.eatMore.dto.*;
import com.eatMore.entity.Shop;
import com.eatMore.security.JwtTokenUtil;
import com.eatMore.service.ShopService;
import com.eatMore.service.impl.JwtShopDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/shopAuthentication")
public class ShopController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtShopDetailsServiceImpl jwtShopDetailsService;

    @Autowired
    private ShopService shopService;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtShopRequestDTO requestDTO) throws Exception{
       // System.out.println(requestDTO.getEmail());
       // authenticate(requestDTO.getEmail(), requestDTO.getPassword());

        final UserDetails userDetails = jwtShopDetailsService.loadUserByUsername(requestDTO.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        Shop shop = jwtShopDetailsService.getShop(requestDTO.getEmail());

        final String name = shop.getName();
        final String email = shop.getEmail();
        final String contactNo = shop.getContactNo();
        final String contactPersonName = shop.getContactPersonName();

        return  ResponseEntity.ok(new JwtShopResponseDTO(token, name, email, contactNo, contactPersonName));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerShop(@RequestBody ShopSignUpDTO dto) throws  Exception{
        return ResponseEntity.ok(jwtShopDetailsService.saveShop(dto));
    }

    @GetMapping(value = "/retriveShops")
    public List<ShopDTO> getAllShops(){
        return shopService.getAllShops();
    }


    private void authenticate(String email, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }catch (DisabledException e){
            throw  new Exception("User Disabled", e);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }
    }

}
