package com.Proxym.EventManagementSys.repository;

import com.Proxym.EventManagementSys.model.ERole;
import com.Proxym.EventManagementSys.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
