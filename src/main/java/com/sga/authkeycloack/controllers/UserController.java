package com.sga.authkeycloack.controllers;

import com.sga.authkeycloack.configs.KeycloackSecurity;
import com.sga.authkeycloack.domain.User;
import com.sga.authkeycloack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    KeycloackSecurity keycloackSecurity;

//    @PostMapping("/create")
//    public void createUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
////        userService.createUser(username, email, password);
//    }

    @GetMapping("/list")
    public List<?> list(){
        return  userService.listUsers();
    }

    @PostMapping("/create")
    public Response create(@RequestBody User user){
        return userService.registerUser(user);
    }

//    @GetMapping("/find/email")
//    public List<UserRepresentation> findByEmail(@RequestParam String email){
//        return userService.findByEmail(email);
//    }

    @DeleteMapping("/delete/:id")
    public void deleteUser(@PathVariable String id){
        userService.deleteUsers(id);
    }
}
