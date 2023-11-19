package org.joel.springcloud.msvc.users.domain.repositories;

import org.joel.springcloud.msvc.users.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

}
