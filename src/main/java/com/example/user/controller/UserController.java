package com.example.user.controller;

import com.example.user.models.request.UserRequest;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  User  -> Registrar usuario.
     *
     * @return ResponseEntity --> User
     */
    @PostMapping(value = "/user")
    public ResponseEntity<Map<String, Object>> save(@RequestBody(required = true) UserRequest user) {
        return userService.save(user);
    }

}
