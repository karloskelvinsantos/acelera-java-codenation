package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController implements Serializable {

    protected final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public User oneUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        });
    }

    @GetMapping
    public List<User> userByAccelerationName(@RequestParam(value = "accelerationName", required = false) String accelerationName,
                                             @RequestParam(value = "companyId", required = false) Long companyId) {

        if (accelerationName != null) {
            return userService.findByAccelerationName(accelerationName);
        } else if (companyId != null) {
            return userService.findByCompanyId(companyId);
        }

        return null;
    }

}
