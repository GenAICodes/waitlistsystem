
package com.waitlistsystem.controller;

import com.waitlistsystem.service.WaitlistAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/waitlist_analytics")
public class WaitlistAnalyticsController {

    @Autowired
    private WaitlistAnalyticsService waitlistAnalyticsService;

    @GetMapping("/number_of_users")
    public ResponseEntity<Integer> getNumberOfUsers() {
        int numberOfUsers = waitlistAnalyticsService.getNumberOfUsers();
        return ResponseEntity.ok(numberOfUsers);
    }

    @GetMapping("/average_wait_time")
    public ResponseEntity<Double> getAverageWaitTime() {
        double averageWaitTime = waitlistAnalyticsService.getAverageWaitTime();
        return ResponseEntity.ok(averageWaitTime);
    }

    @GetMapping("/longest_wait_time")
    public ResponseEntity<Long> getLongestWaitTime() {
        Long longestWaitTime = waitlistAnalyticsService.getLongestWaitTime();
        return ResponseEntity.ok(longestWaitTime);
    }

    @GetMapping("/shortest_wait_time")
    public ResponseEntity<Long> getShortestWaitTime() {
        Long shortestWaitTime = waitlistAnalyticsService.getShortestWaitTime();
        return ResponseEntity.ok(shortestWaitTime);
    }
}
