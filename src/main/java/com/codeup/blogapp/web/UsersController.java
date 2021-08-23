package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import com.codeup.blogapp.data.UsersRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = "application/json")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<User> getUsers() {
        return usersRepository.findAll();
    }

    @PostMapping
    private void createUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

    }

    @PutMapping("{/id}")
    private void editUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("Editing user ID: " + id);
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());

    }

    @DeleteMapping("{/id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with ID: " + id);
    }

    @PostMapping({"{id}"})
    private void findById(@PathVariable Long id){
        System.out.println("Id: " + id);
    }

    @PostMapping("/findByUsername")
    private void findByUsername(@RequestParam String username){
        System.out.println("Username: " + username);
    }

    @PostMapping("/findByEmail")
    private void findByEmail(@RequestParam String email){
        System.out.println("E-mail: " + email);
    }

    @PutMapping({"{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        if(!newPassword.equals(oldPassword)){
            System.out.println("Password for id: " + id + " has been updated!");
            System.out.println("Old password: " + oldPassword);
            System.out.println("New password: " + newPassword);
        }
    }

}
