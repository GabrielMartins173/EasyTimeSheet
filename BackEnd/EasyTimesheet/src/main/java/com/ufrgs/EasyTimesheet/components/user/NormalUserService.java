package com.ufrgs.EasyTimesheet.components.user;

import com.ufrgs.EasyTimesheet.models.User;
import com.ufrgs.EasyTimesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalUserService {

    @Autowired
    private UserRepository normalUserRepository;

    public List<User> findAllUser() {
        List<User> normalUserList = new ArrayList<>();

        normalUserRepository.findAll().forEach(user -> normalUserList.add(user));

        return normalUserList;
    }


    public User create(User normalUser) {
        return normalUserRepository.save(normalUser);
    }

    public User login(String login, String password) {
        User normalUser = normalUserRepository.findByUsernameIgnoreCase(login);

        if(normalUser.getPassword().equals(password)){
            normalUser.setPassword("");
            return normalUser;
        }
        else {
            return new User();
        }
    }
    public User findByEmail(User normalUser)
    {
        String email = normalUser.getEmail();
        User newNormalUser = normalUserRepository.findByEmailIgnoreCase(email);
        newNormalUser.setPassword("");
        return newNormalUser;
    }

    public User findByLogin(User normalUser)
    {
        String login = normalUser.getUsername();
        User newNormalUser = normalUserRepository.findByUsernameIgnoreCase(login);
        newNormalUser.setPassword("");
        return newNormalUser;
    }
    public User findById(Long id)
    {
        User newNormalUser = normalUserRepository.findById(id).orElseThrow();
        return newNormalUser;
    }
}