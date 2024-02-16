package com.identityservice.service;

import com.identityservice.entity.UserCredentials;
import com.identityservice.repository.UserCredentialsRepository;
import com.identityservice.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialsRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredentials userCredentials){
//        IMP STEP
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));;
        repository.save(userCredentials);
        return "User added to the system";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);;
    }

}
