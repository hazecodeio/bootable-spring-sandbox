package org.hsmak.jpaWithCrudRepository.repository;

import org.hsmak.jpaWithCrudRepository.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/*
 * Link: https://www.baeldung.com/spring-data-repositories
 * JpaRepository has it all
 */
public interface UserWithPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {
}
