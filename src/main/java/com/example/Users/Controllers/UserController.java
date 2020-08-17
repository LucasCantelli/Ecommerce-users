package com.example.Users.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path="/check")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }
}
