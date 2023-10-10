package br.icaromartins.todolisticaro.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_entity")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "nome_usuario", nullable = false, length = 20, unique = true)
    private String userName;
    @Column(name = "nome", nullable = false, length = 40)
    private String name;
    @Column(name = "senha", nullable = false, length = 15)
    private String passoword;

    @CreationTimestamp
    private LocalDateTime createadAt;
}
