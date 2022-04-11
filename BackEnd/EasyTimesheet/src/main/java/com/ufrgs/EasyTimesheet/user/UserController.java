package com.ufrgs.EasyTimesheet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody Login login) {

        User user = userService.login(login.getLogin(), login.getPwd());

        if(user.getEmail() == null) {
            return ResponseEntity.badRequest().body(user);
        } else {
            return ResponseEntity.ok().body(user);
        }

    }

    @PostMapping("/user/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        if (createdUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(createdUser);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAll()
    {
        List<User> userList = userService.findAllUser();

        if(userList == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return ResponseEntity.ok().body("success");
    }

}
