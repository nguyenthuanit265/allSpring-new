package com.learn.service.impl;

import com.learn.model.dto.SpringSecurityUserDetailsDto;
import com.learn.model.entity.User;
import com.learn.model.request.AuthRequest;
import com.learn.model.response.AllSpringResponse;
import com.learn.model.response.AuthResponse;
import com.learn.security.JwtTokenUtils;
import com.learn.service.SimpleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {
    private final Logger LOGGER = LoggerFactory.getLogger(SimpleServiceImpl.class);
    private final AuthenticationManager authManager;
    private final JwtTokenUtils jwtUtils;
    private final ModelMapper modelMapper;

    public SimpleServiceImpl(AuthenticationManager authManager,
                             JwtTokenUtils jwtUtils,
                             ModelMapper modelMapper) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> simpleLogin(AuthRequest request) {
        try {

            // Spring Security use authenticate function -> call functions loadUserByUsername and get username and password -> using PasswordEncoder Bean authenticate user login
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            // Get user login info
            SpringSecurityUserDetailsDto userDetails = (SpringSecurityUserDetailsDto) authentication.getPrincipal();
            User user = modelMapper.map(userDetails, User.class);
            String accessToken = jwtUtils.generateAccessToken(user);

            // Response
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

            return new ResponseEntity<>(AllSpringResponse.buildResponse(response, 0, "Login Successfully", HttpStatus.OK.value()), HttpStatus.OK);

        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(AllSpringResponse.buildResponse(null, 0, "Cannot login", HttpStatus.UNAUTHORIZED.value()), HttpStatus.BAD_REQUEST);
        }
    }
}
