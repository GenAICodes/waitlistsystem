
package com.waitlistsystem.controller;

import com.waitlistsystem.model.User;
import com.waitlistsystem.service.WaitlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class WaitlistController {

    private final WaitlistService waitlistService;

    @Autowired
    public WaitlistController(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @PostMapping
    public ResponseEntity<Integer> addUser(@RequestParam String name, @RequestParam String email, @RequestParam String phone) {
        waitlistService.addUser(name, email, phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable int userId) {
        waitlistService.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = waitlistService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}/position")
    public ResponseEntity<Integer> getPosition(@PathVariable int userId) {
        int position = waitlistService.getPosition(userId);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }
}
