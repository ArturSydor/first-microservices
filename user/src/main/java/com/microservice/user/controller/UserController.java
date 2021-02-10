package com.microservice.user.controller;

import com.microservice.user.dto.UserInformationDto;
import com.microservice.user.entity.User;
import com.microservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User crete(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public UserInformationDto getUserWithDepartment(@PathVariable("userId") Long userId) {
        return userService.getUserWithDepartment(userId);
    }

}
