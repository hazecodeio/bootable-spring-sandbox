package org.hsmak.jpaWithCrudRepositoryAndBidirMappings.repository;

import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car, Long> {
}
