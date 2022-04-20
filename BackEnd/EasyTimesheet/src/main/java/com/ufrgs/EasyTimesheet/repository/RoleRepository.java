package com.ufrgs.EasyTimesheet.repository;
import java.util.Optional;

import com.ufrgs.EasyTimesheet.models.ERole;
import com.ufrgs.EasyTimesheet.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}