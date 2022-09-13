package com.myrealstock.user.presentation;

import com.myrealstock.user.domain.User;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    private String userId;
    private String password;
    private String email;
    private String nickName;
    private String phoneNum;

    private Set<AuthorityDto> authorityDtoSet;

    public static SignUpDto from(User user) {
        if(user == null) return null;

        return SignUpDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .nickName(user.getNickName())
                .phoneNum(user.getPhoneNum())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
