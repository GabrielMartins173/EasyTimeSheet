package com.ufrgs.EasyTimesheet.components.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class NormalUserController {

    @Autowired
    private NormalUserService normalUserService;


    @PostMapping("/user/login")
    public ResponseEntity<NormalUser> login(@RequestBody Login login) {

        NormalUser normalUser = normalUserService.login(login.getLogin(), login.getPwd());

        if(normalUser.getEmail() == null) {
            return ResponseEntity.badRequest().body(normalUser);
        } else {
            return ResponseEntity.ok().body(normalUser);
        }

    }

    @PostMapping("/user/create")
    public ResponseEntity<NormalUser> create(@RequestBody NormalUser normalUser) {
        NormalUser createdNormalUser = normalUserService.create(normalUser);

        if (createdNormalUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(createdNormalUser);
    }

    @GetMapping("/user")
    public ResponseEntity<List<NormalUser>> findAll()
    {
        List<NormalUser> normalUserList = normalUserService.findAllUser();

        if(normalUserList == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(normalUserList);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return ResponseEntity.ok().body("success");
    }

}
