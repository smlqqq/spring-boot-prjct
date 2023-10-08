package com.alex.d.security.service.user;

import com.alex.d.security.models.user.RoleModel;
import com.alex.d.security.models.user.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class MyUserDetails implements UserDetails {

    private final UserModel user;

    public MyUserDetails(UserModel user){
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//      Set<RoleModel>roles = user.getRole();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for(RoleModel role : roles){
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

}
