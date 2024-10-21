package com.codigo.examen.repository;

import com.codigo.examen.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByIdAndStatus(Long id, String status);
    Optional<PersonEntity> findByIdNumber(String idNumber);
    List<PersonEntity> getAllByStatus(String status);
}
