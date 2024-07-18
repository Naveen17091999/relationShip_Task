package com.SpringBasics.Aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void createUser(String name) {
        System.out.println("Creating user: " + name);
    }

    public void deleteUser(String name){
        System.out.println("Deleting user: " + name);
    }

    public void getUser(String name){
        System.out.println("Getting user: " + name);
    }

    public void throwing() throws Exception {
        throw new Exception("this is a demo exception.");
    }
}
