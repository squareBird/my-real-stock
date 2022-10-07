package com.myrealstock.user.presentation;

import com.myrealstock.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }



}

//@AllArgsConstructor
//@RestController
//public class UserController {
//
//
//    private final UserService userService;
//    private final UserRepository userRepository;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    // 회원가입
//    @PostMapping("/join")
//    public void join(@RequestBody Map<String, String> userInfo) {
//        userService.save(userInfo);
//    }
//
//    // 로그인
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> user) {
//        User member = userRepository.findByUserEmail(user.get("email"))
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
//
//        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
//    }
//
//}
