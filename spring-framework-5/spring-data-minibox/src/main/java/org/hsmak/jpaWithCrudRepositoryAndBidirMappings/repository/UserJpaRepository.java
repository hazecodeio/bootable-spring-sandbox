package org.hsmak.jpaWithCrudRepositoryAndBidirMappings.repository;

import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Link: https://www.baeldung.com/spring-data-repositories
 * JpaRepository has it all
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
}
