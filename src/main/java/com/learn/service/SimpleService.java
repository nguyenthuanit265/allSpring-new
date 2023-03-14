package com.learn.service;

import com.learn.model.request.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface SimpleService {
    ResponseEntity<?> simpleLogin(AuthRequest request);
}
