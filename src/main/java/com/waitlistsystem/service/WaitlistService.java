
package com.waitlistsystem.service;

import com.waitlistsystem.model.User;
import java.util.List;

public interface WaitlistService {
    void addUser(String name, String email, String phone);
    void removeUser(int userId);
    List<User> getUsers();
    int getPosition(int userId);
}
