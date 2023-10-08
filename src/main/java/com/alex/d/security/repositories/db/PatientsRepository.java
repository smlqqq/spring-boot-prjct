package com.alex.d.security.repositories.db;

import com.alex.d.security.models.db.PatientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsModel, Long> {

}
