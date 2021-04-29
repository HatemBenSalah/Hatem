package com.hms.controller;

import javax.validation.Valid;

import com.hms.entity.*;

import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.UserRepository;
import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import com.hms.response.JwtResponse;
import com.hms.response.MessageResponse;
import com.hms.security.jwt.JwtUtils;
import com.hms.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        return ResponseEntity
                .ok(new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getEmail(),
                        userDetails.getRoles(),
                        userDetails.getPhone(),
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getCin(),
                        userDetails.getAdresse()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {


        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        if (signUpRequest.getRoles().equals(null)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Roles is not found!"));
        }

        // Create new user's account
        UserEntity user = new UserEntity(
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getRoles(), signUpRequest.getPhone(), signUpRequest.getFirstName(),
                signUpRequest.getLastName(), signUpRequest.getCin(), signUpRequest.getAdresse());


        userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

  /*  @PostMapping("/getUser")

    public List <CommandeEntity >getUser(@Valid @RequestBody UserEntity userEntity)throws ResourceNotFoundException {
        List <CommandeEntity> user = userRepository.getCommandesByUser(userEntity.getId());
        System.out.println("user:"+user);
        return user;
    }*/
}