package org.hsmak.jpaWithCrudRepository.repository;

import org.hsmak.jpaWithCrudRepository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Link: https://www.baeldung.com/spring-data-repositories
 * JpaRepository has it all
 */
public interface UserWithJpaRepository extends JpaRepository<User, Long> {
}
