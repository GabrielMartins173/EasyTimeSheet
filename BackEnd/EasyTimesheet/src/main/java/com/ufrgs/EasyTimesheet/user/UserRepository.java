package com.ufrgs.EasyTimesheet.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public List<User> findAllByNameIgnoreCase(String name);

    public User findByEmailIgnoreCase(String email);

    public User findByLoginIgnoreCase(String login);

    public User save(User user);

    public User findById(long id);

    public List<User> findAll();




}