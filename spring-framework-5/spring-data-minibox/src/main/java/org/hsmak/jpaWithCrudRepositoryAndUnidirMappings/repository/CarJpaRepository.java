package org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.repository;

import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car, Long> {
}
