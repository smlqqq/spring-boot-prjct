package com.alex.d.security.entity.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "role", schema = "user")
@Table(name = "role")
public class RoleModel implements GrantedAuthority {

    @Getter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "role")
    private Set<UserModel> users;

    @Override
    public String getAuthority() {
        return getName();
    }

    public RoleModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
