package com.ufrgs.EasyTimesheet.components.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalUserService {

    @Autowired
    private NormalUserRepository normalUserRepository;

    public List<NormalUser> findAllUser() {
        List<NormalUser> normalUserList = new ArrayList<>();

        normalUserRepository.findAll().forEach(user -> normalUserList.add(user));

        return normalUserList;
    }


    public NormalUser create(NormalUser normalUser) {
        return normalUserRepository.save(normalUser);
    }

    public NormalUser login(String login, String password) {
        NormalUser normalUser = normalUserRepository.findByLoginIgnoreCase(login);

        if(normalUser.getPwd().equals(password)){
            normalUser.setPwd("");
            return normalUser;
        }
        else {
            return new NormalUser();
        }
    }
    public NormalUser findByEmail(NormalUser normalUser)
    {
        String email = normalUser.getEmail();
        NormalUser newNormalUser = normalUserRepository.findByEmailIgnoreCase(email);
        newNormalUser.setPwd("");
        return newNormalUser;
    }

    public NormalUser findByLogin(NormalUser normalUser)
    {
        String login = normalUser.getLogin();
        NormalUser newNormalUser = normalUserRepository.findByLoginIgnoreCase(login);
        newNormalUser.setPwd("");
        return newNormalUser;
    }
    public NormalUser findById(Long id)
    {
        NormalUser newNormalUser = normalUserRepository.findById(id).orElseThrow();
        return newNormalUser;
    }
}