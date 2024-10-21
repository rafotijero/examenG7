package com.codigo.examen.repository;

import com.codigo.examen.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByIdAndStatusNot(Long id, String Status);
    List<OrderEntity> findByIdOrStatus(Long id, String Status);
    List<OrderEntity> getAllByStatus(String status);
}
