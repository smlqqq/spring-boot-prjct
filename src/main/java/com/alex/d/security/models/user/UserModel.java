package com.alex.d.security.models.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
/*@Table(name = "users", schema = "user")*/
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<RoleModel> role = new HashSet<>();

//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<RoleModel>roles = getRole();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for(RoleModel role : roles){
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }



//    @Override
//    public String getPassword() {
//        return password;
//    }


//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<RoleModel> role = new HashSet<>();
}
