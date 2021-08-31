package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import com.mycompany.vo.RestTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside method of UserController.saveUser ");
        return userService.saveUser(user);
        
    }
    
    @GetMapping("{id}")
    public RestTemplateVO getUserAndDeptByUserId(@PathVariable(name = "id") Long userId) {
        log.info("inside method of UserController.getUserAndDeptByUserId ");
        return userService.getUserAndDeptByUserId(userId);
    }
}
