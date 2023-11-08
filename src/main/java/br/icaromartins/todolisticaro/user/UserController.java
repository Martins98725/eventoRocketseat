package br.icaromartins.todolisticaro.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
  private IUserRepository repository;
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
            var user = this.repository.findByUserName(userModel.getUsername());
            if (user != null){
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existe");
            }
            var passowordHasherd = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
            userModel.setPassword(passowordHasherd);
            var userCreatead = this.repository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreatead);
    }
    @GetMapping("/user")
    public ResponseEntity findAll(){
        List<UserModel> users = this.repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}