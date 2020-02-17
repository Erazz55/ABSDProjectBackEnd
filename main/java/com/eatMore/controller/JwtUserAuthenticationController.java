package com.eatMore.controller;

import com.eatMore.dto.JwtRequestDTO;
import com.eatMore.dto.JwtResponseDTO;
import com.eatMore.dto.SignUpDTO;
import com.eatMore.security.JwtTokenUtil;
import com.eatMore.service.impl.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/userAuthentication")
public class JwtUserAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO requestDTO) throws Exception{
        authenticate(requestDTO.getUsername(), requestDTO.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(requestDTO.getUsername());
        if(bCryptPasswordEncoder.matches(requestDTO.getPassword(), userDetails.getPassword())){
            final String token = jwtTokenUtil.generateToken(userDetails);
            return  ResponseEntity.ok(new JwtResponseDTO(token));
        }else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody SignUpDTO dto) throws Exception{
        return ResponseEntity.ok(jwtUserDetailsService.saveUser(dto));
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw  new Exception("User Disabled", e);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }
    }
}
