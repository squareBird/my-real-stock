package com.myrealstock.user.application;


import com.myrealstock.user.domain.Authority;
import com.myrealstock.user.domain.User;
import com.myrealstock.user.domain.UserRepository;
import com.myrealstock.user.presentation.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public SignUpDto signup(SignUpDto signUpDto) {
        if (userRepository.findOneWithAuthoritiesByUserId(signUpDto.getUserId()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .userId(signUpDto.getUserId())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .email(signUpDto.getEmail())
                .nickName(signUpDto.getNickName())
                .phoneNum(signUpDto.getPhoneNum())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return SignUpDto.from(userRepository.save(user));
    }


}
