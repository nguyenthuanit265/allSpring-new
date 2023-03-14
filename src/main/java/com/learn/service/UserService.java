package com.learn.service;

import com.learn.model.dto.SpringSecurityUserDetailsDto;

import java.util.Optional;

public interface UserService {
    Optional<SpringSecurityUserDetailsDto> simpleFindByUsername(String username);
}
