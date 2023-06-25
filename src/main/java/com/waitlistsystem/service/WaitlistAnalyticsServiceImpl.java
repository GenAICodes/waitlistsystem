
package com.waitlistsystem.service;

import com.waitlistsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitlistAnalyticsServiceImpl implements WaitlistAnalyticsService {

    private final UserRepository userRepository;

    @Autowired
    public WaitlistAnalyticsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public double getAverageWaitTime() {
        return userRepository.getAverageWaitTime();
    }
}
