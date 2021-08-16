package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/users", headers = "Accept=application/json")
public class UsersController {

    private List<User> getUser(){

        return new ArrayList<User>(){{

            add(new User())
        }};

    }

}
