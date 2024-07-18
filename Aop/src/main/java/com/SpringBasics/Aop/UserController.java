package com.SpringBasics.Aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    public UserService service;

    @GetMapping("/before/{name}")
    public String before(@PathVariable String name) {
        service.createUser(name);
        return "test AOp";
    }

    @GetMapping("/after/{name}")
    public String after(@PathVariable String name) {
        service.deleteUser(name);
        return "test AOp";
    }

    @GetMapping("/afterReturning/{name}")
    public String afterReturning(@PathVariable String name) {
        service.getUser(name);
        return "test AOp";
    }

    @GetMapping("/throwing")
    public String throwing() throws Exception {
        service.throwing();
        return "test AOp";
    }

}