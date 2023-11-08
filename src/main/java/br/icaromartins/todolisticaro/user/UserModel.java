package br.icaromartins.todolisticaro.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_users")
@Entity(name = "users")
@Data
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "nome_usuario", nullable = false, length = 20, unique = true)
    private String userName;

    @Column(name = "nome", nullable = false, length = 40)
    private String name;

    @Column(name = "senha", nullable = false)
    private String password;

    private UserRoles role;

    private String login;

    @CreationTimestamp
    private LocalDateTime createadAt;

    public UserModel(String login, String password, UserRoles role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if (this.role.equals(UserRoles.ADIMIN)) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
       else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
