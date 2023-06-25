
package com.waitlistsystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailScheduler {
    @Autowired
    private EmailService emailService;

    private List<ScheduledEmail> scheduledEmails = new ArrayList<>();

    public void scheduleWaitlistNotificationEmail(String toAddress, String name, int rank, LocalDateTime scheduledTime) {
        scheduledEmails.add(new ScheduledEmail(toAddress, name, rank, scheduledTime));
    }

    @Scheduled(fixedDelay = 60000)
    public void sendScheduledEmails() {
        List<ScheduledEmail> emailsToSend = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (ScheduledEmail email : scheduledEmails) {
            if (email.getScheduledTime().isBefore(now)) {
                emailsToSend.add(email);
            }
        }
        for (ScheduledEmail email : emailsToSend) {
            emailService.sendEmail(email.getToAddress(), "Waitlist Notification", EmailTemplate.getWaitlistNotificationEmail(email.getName(), email.getRank()));
            scheduledEmails.remove(email);
        }
    }
}
