package com.bhaskar.userservice.controller;

import com.bhaskar.userservice.VO.ResponseTemplateVO;
import com.bhaskar.userservice.entity.User;
import com.bhaskar.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    @PostMapping(value = "/save")
    public User save(@RequestBody User user){

        return service.save(user);
    }
    @GetMapping(value = "/list")
    public List<User> list(){

        return service.list();
    }

    @GetMapping(value = "/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){

        return service.getUserWithDepartment(userId);
    }
}
