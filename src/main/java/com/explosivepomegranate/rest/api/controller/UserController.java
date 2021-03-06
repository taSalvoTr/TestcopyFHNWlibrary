package com.explosivepomegranate.rest.api.controller;

import com.explosivepomegranate.rest.api.model.Login;
import com.explosivepomegranate.rest.api.model.Role;
import com.explosivepomegranate.rest.api.model.User;
import com.explosivepomegranate.rest.api.repository.LoginRepository;
import com.explosivepomegranate.rest.api.repository.RoleRepository;
import com.explosivepomegranate.rest.api.repository.UserRepository;
import com.explosivepomegranate.rest.api.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    //TEST PURPOSES:
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    RoleRepository roleRepository;

    /**
     * @author: Salvatore
     * Registers a new account (UC3)
     * */
    @PostMapping(path = "/myNewUser", produces = "application/json", consumes = "application/json")
    public ResponseEntity<JsonNode> postNewUser(@RequestBody JsonNode jsonNode) {
        try{
            userService.saveNewUser(jsonNode);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(jsonNode);
    }

    /**
     * @author Clelia
     * return USER_ROLE
     * */
    @GetMapping(path = "/userRole", produces = "application/json")
    public Boolean isAdminRole(Authentication authentication) {
        return userService.isAdminRole(authentication);
    }

    /**
     * @author Clelia
     * return User information*
     * */
    @GetMapping(path="/myUserProfile", produces = "application/json")
    public User getUser(Authentication authentication){
        return userService.getProfileInformation(authentication);
    }

    /**
     * @author Clelia
     * return User information*
     * @return*/
    @PostMapping(path="/updateMyUserProfile", produces = "application/json", consumes = "application/json")
    public User updateUser(@RequestBody User updatedUser, Authentication authentication){
        return userService.updateProfileInformation(updatedUser, authentication);
    }


    // TODO remove these unused and dangerous methods after testing
    /**
    * @author: Salvatore
     * returns list of all users, roles, logins (for testing purposes)
     * */
    @GetMapping (path = "/allUserAccounts", produces = "application/json")
    public List<User> getUsers() { return userRepository.findAll(); }

    @GetMapping (path = "/allLogins", produces = "application/json")
    public List<Login> getLogins() { return loginRepository.findAll(); }

    @GetMapping (path = "/allRoles", produces = "application/json")
    public List<Role> getRoles() { return roleRepository.findAll(); }

}
