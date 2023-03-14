package com.learn.service.impl;

import com.learn.model.dto.SpringSecurityUserDetailsDto;
import com.learn.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Optional<SpringSecurityUserDetailsDto> simpleFindByUsername(String email) {
        if (ObjectUtils.isEmpty(email)) {
            return Optional.empty();
        }
        // TODO Query DB

        if ("admin@gmail.com".equals(email)) {
            return Optional.ofNullable(SpringSecurityUserDetailsDto.builder()
                    .id(1L)
                    .username("admin")
                    .email(email)
                    .password("123456")
                    .build());
        }
        return Optional.empty();
    }
}
