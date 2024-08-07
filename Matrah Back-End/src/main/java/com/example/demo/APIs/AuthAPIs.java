package com.example.demo.APIs;

import com.example.demo.DTOs.LoginReqDTO;
import com.example.demo.DTOs.LoginResDTO;
import com.example.demo.JwtUtil;
import com.example.demo.Services.UserService;
import com.example.demo.Entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthAPIs {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthAPIs(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO request) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            if(authentication.isAuthenticated()) {
                User user = userService.getUserByUserName(request.getUsername());
                String token = jwtUtil.GenerateToken(user);
                LoginResDTO response = new LoginResDTO(user.getUserName(), user.getId(), user.getRole(), token);
                return ResponseEntity.ok(response);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(request);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody User _user){
        userService.createUser(_user);
        User user = userService.getUserByUserName(_user.getUserName());
        String token = jwtUtil.GenerateToken(user);
        LoginResDTO response = new LoginResDTO(user.getUserName(), user.getId(), user.getRole(), token);
        return ResponseEntity.ok(response);
    }
}
