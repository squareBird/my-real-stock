package com.myrealstock.user.presentation;

import com.myrealstock.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signup(@Valid @RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(userService.signup(signUpDto));
    }

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
