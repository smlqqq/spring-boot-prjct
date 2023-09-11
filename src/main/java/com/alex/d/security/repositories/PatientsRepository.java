package com.alex.d.security.repositories;

import com.alex.d.security.models.PatientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsModel, Long> {
}
