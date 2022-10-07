package com.myrealstock.user.presentation;

import com.myrealstock.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService userService;

    @GetMapping("/")
    public String userLogin() {
        return "login";
    }

//    @GetMapping("/node")
//    public ResponseEntity urlRedirect() {
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setLocation(URI.create("http://localhost:3000"));
//
//
//        return new ResponseEntity("Redirect", responseHeaders, HttpStatus.MOVED_PERMANENTLY);
//    }


    @GetMapping("/logout")
    public String userLogout() {
        return "logout";
    }


    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signup(@Valid @RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(userService.signup(signUpDto));
    }
}
