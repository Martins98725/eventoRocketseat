package br.icaromartins.todolisticaro.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface SRepositoryUser extends JpaRepository<UserModel, UUID> {
   UserDetails findByLogin(String login);
   UserModel findByUserName(String userName);
}
