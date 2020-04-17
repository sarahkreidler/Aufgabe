package com.programcreek.helloworld.services;
import org.springframework.stereotype.Service;
@Service("helloWorldService")
public class HelloWorldService {
    private String name;

    //Konstruktor
    public void setName(String name) {
        this.name = name;
    }

    //Methode
    public String sayHello() {
        return "Hello! " + name;
    }
}