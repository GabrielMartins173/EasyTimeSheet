package com.ufrgs.EasyTimesheet.components.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NormalUserRepository extends PagingAndSortingRepository<NormalUser, Long> {

    public List<NormalUser> findAllByNameIgnoreCase(String name);

    public NormalUser findByEmailIgnoreCase(String email);

    public NormalUser findByLoginIgnoreCase(String login);

    public NormalUser save(NormalUser normalUser);

    public NormalUser findById(long id);

    public List<NormalUser> findAll();




}