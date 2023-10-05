/*
package com.alex.d.security.service;

import com.alex.d.security.models.RoleModel;
import com.alex.d.security.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsPrincipal implements UserDetails {

    private final UserModel userModel;
@Autowired
    public UserDetailsPrincipal(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleModel> roleModels = (Set<RoleModel>) userModel.getRoleModel();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleModel roleModel : roleModels) {
            authorities.add(new SimpleGrantedAuthority(roleModel.getName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getLogin();
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
*/
