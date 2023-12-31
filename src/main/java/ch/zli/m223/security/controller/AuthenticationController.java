package ch.zli.m223.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.security.dto.JwtTokenDto;
import ch.zli.m223.security.dto.SignInDto;
import ch.zli.m223.security.dto.SignUpDto;
import ch.zli.m223.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    
    /**
     * Sign up
     * @param data everything you want to sign up in the signup object
     * @return HttpStatus.OK & a new Token
     */
    @PostMapping("/signup")
    JwtTokenDto signup(@RequestBody SignUpDto data) {
        return authenticationService.signup(data);
    }

    /**
     * Sign in
     * @param data everything you want to signin object
     * @return (HttpStatus.OK & a new Token) or HttpStatus.BAD_REQUEST)
     */
    @PostMapping("/signin")
    JwtTokenDto signin(@RequestBody SignInDto data) {
        return authenticationService.signin(data);
    }
}
