package crisci.caterina.goodstream.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crisci.caterina.goodstream.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
@JsonIgnoreProperties({
        "password", "credentialsNonExpired", "accountNonExpired",
        "authorities", "username", "accountNonLocked", "enabled"
})
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String fullName;

    private String email;

    private String password;

    @ManyToMany
    private List<Title> library;

    @OneToMany
    private List<Review> reviews;
}

//public static User fromDTO(UserDTO userDTO) {
////    User user = new User();
//}

//public Collection<? extends GrantedAuthority> getAuthorities() {
//    List<SimpleGrantedAuthority> list = this.role.stream().map(element -> new SimpleGrantedAuthority(element.name())).toList();
// return List;
//}
