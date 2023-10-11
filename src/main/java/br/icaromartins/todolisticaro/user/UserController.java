package br.icaromartins.todolisticaro.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
  private IUserRepository repository;
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
            var user = this.repository.findByUserName(userModel.getUserName());
            if (user != null){
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existe");

            }
            var passowordHasherd = BCrypt.withDefaults().hashToString(12, userModel.getPassoword().toCharArray());
            userModel.setPassoword(passowordHasherd);
            var userCreatead = this.repository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreatead);
    }
}
