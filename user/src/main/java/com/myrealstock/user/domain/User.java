package com.myrealstock.user.domain;

import lombok.*;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userid", length = 100, nullable = false, unique = true)
    private String userId;

    @Column(name="password", length = 500, nullable = false)
    private String password;

    @Column(name="email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name="nickname", length = 30, nullable = false)
    private String nickName;

    @Column(name = "phonenum")
    private String phoneNum;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}

