
package com.waitlistsystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class WaitlistEmailScheduler {

    private final WaitlistEmailService waitlistEmailService;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    public WaitlistEmailScheduler(WaitlistEmailService waitlistEmailService) {
        this.waitlistEmailService = waitlistEmailService;
    }

    public void scheduleWaitlistNotificationEmail(String recipientEmail, String recipientName, int position, LocalDateTime scheduledTime, String emailTemplate) {
        long delay = Duration.between(LocalDateTime.now(), scheduledTime).toMillis();
        scheduledExecutorService.schedule(() -> {
            try {
                waitlistEmailService.sendWaitlistNotificationEmail(recipientEmail, recipientName, position, emailTemplate);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }, delay, TimeUnit.MILLISECONDS);
    }
}
