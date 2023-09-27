package com.alex.d.security.repositories;

import com.alex.d.security.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
