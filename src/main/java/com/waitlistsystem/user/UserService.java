
    package com.waitlistsystem.user;
    import java.util.List;
    public interface UserService {
        void registerUser(String email);
        int getWaitlistRank(String email);
        List<User> getAllUsers();
    }
