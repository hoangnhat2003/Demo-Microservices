package com.microservice.authserver.domain.repository;

import com.microservice.authserver.domain.document.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT DISTINCT r.name FROM tbl_role_permission_activities rpa " +
            "INNER JOIN tbl_roles r ON rpa.role_id = r.id " +
            "INNER JOIN tbl_user_roles usr ON usr.role_id = r.id " +
            "WHERE usr.user_id = (SELECT u.id FROM tbl_users u WHERE u.username = :username)", nativeQuery = true)
    List<String> findRoleByUsername(String username);

    User findByEmail(String email);
}
