package com.ufrgs.EasyTimesheet.repository;

import java.util.List;
import java.util.Optional;

import com.ufrgs.EasyTimesheet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  public List<User> findAllByNameIgnoreCase(String name);

  public User findByEmailIgnoreCase(String email);

  public User findByUsernameIgnoreCase(String login);

  public User save(User normalUser);

  public User findById(long id);

  public List<User> findAll();
}