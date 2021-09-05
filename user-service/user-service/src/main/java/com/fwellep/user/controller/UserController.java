package com.fwellep.user.controller;

import com.fwellep.user.VO.ResponseTemplateVO;
import com.fwellep.user.entity.User;
import com.fwellep.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        log.info("Inside getAllUsers method of UserController");
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        log.info("Inside updateUser of UserController");
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserAndInfo(@PathVariable("id") Long userId) {
        log.info("Inside deleteDepartmentById method of departmentService");
       return userService.deleteUserAndInfo(userId);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserInfo(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserInfo(userId);
    }
}
