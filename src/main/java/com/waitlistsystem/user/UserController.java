
    package com.waitlistsystem.user;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    @RestController
    @RequestMapping("/users")
    public class UserController {
        @Autowired
        private UserService userService;
        @PostMapping("/register")
        public void registerUser(@RequestParam String email) {
            userService.registerUser(email);
        }
        @GetMapping("/waitlist-rank")
        public int getWaitlistRank(@RequestParam String email) {
            return userService.getWaitlistRank(email);
        }
        @GetMapping("/all")
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }
    }
