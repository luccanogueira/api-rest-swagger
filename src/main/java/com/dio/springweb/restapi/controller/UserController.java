package com.dio.springweb.restapi.controller;

import com.dio.springweb.restapi.model.User;
import com.dio.springweb.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getLIstUser(){
        return repository.findAll();
    }

    @GetMapping("/{userName}")
    public User buscaNome(@PathVariable("userName") String userName){
        return repository.findByUsername(userName);
    }

    @GetMapping("/{id}")
    public User buscaId(@PathVariable("id") Integer id){
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        return repository.deleteById(id);
    }

    @PostMapping
    public void AddUser(@RequestBody User usuario){
        repository.save(usuario);
    }
}
