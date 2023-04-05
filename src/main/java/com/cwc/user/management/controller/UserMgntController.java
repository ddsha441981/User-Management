package com.cwc.user.management.controller;

import com.cwc.user.management.model.User;
import com.cwc.user.management.services.UserMgntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "http://localhost:3000/")
@RequestMapping("/api/v1/users")
public class UserMgntController {
    @Autowired
    UserMgntService userMgntService;

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userMgntService.addUserDetails(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> UpdateUserById(@PathVariable("userId")String userId , @RequestBody User user){
        User user1 = userMgntService.updateUserDetails(userId, user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = userMgntService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){

        User userById = userMgntService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable("userId") String userId){
        boolean deleted = false;
        deleted =  userMgntService.deleteUserById(userId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("user deleted!!" ,deleted);
        return ResponseEntity.ok(response);
    }

}
