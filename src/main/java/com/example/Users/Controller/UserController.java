package com.example.Users.Controller;

import com.example.Users.Model.UserDTO;
import com.example.Users.Service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    UserService userService;

    @GetMapping(path="/check")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("Working on port " + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(createUserRequestModel, UserDTO.class);
        UserDTO response = userService.createUser(userDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
