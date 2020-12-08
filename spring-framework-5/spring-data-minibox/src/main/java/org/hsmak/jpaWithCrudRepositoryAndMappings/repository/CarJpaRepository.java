package org.hsmak.jpaWithCrudRepositoryAndMappings.repository;

import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car, Long> {
}
