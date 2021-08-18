package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = "application/json")
public class UsersController {


    private List<User> getUsers(){
        return new ArrayList<>(){{
            add(new User(1L, "CLE1", "espi.chris117@gmail.com", "BLAHblah"));
        }};
    }

    @PostMapping
    private void createUser(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }

    @PutMapping("{/id}")
    private void editUser(@PathVariable Long id, @RequestBody User user){
        System.out.println("Editing user ID: " + id);
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());

    }
    @DeleteMapping("{/id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with ID: " + id);
    }
}
