package com.alex.d.security.repositories;

import com.alex.d.security.models.PatientsModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaginationRepository extends PagingAndSortingRepository<PatientsModel, Long> {
    List<PatientsModel> findPatientsModelById(Long id, Pageable pageable);
}
