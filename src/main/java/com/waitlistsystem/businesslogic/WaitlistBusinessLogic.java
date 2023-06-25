
package com.waitlistsystem.businesslogic;

import com.waitlistsystem.model.User;
import com.waitlistsystem.service.WaitlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaitlistBusinessLogic {

    private final WaitlistService waitlistService;

    @Autowired
    public WaitlistBusinessLogic(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    public int addUser(String name, String email, String phone) {
        waitlistService.addUser(name, email, phone);
        return waitlistService.getPosition(waitlistService.getUserId(email));
    }

    public void removeUser(int userId) {
        waitlistService.removeUser(userId);
    }

    public List<User> getUsers() {
        return waitlistService.getUsers();
    }

    public int getPosition(int userId) {
        return waitlistService.getPosition(userId);
    }
}
