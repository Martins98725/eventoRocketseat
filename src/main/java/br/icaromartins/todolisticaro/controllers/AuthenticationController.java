package br.icaromartins.todolisticaro.controllers;

import br.icaromartins.todolisticaro.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SRepositoryUser repository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var userNamePassoword = new UsernamePasswordAuthenticationToken(data.login(), data.passoword());
        var auth = this.authenticationManager.authenticate(userNamePassoword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if (this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptPassoword = new BCryptPasswordEncoder().encode(data.passoword());
        UserModel newUser = new UserModel(data.login(), encryptPassoword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
