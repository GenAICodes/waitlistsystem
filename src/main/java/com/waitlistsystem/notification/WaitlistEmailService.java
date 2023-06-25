
package com.waitlistsystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class WaitlistEmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public WaitlistEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendWaitlistNotificationEmail(String recipientEmail, String recipientName, int position, String emailTemplate) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipientEmail);
        helper.setSubject("Waitlist Notification");
        String text = emailTemplate.replace("{name}", recipientName).replace("{position}", String.valueOf(position));
        helper.setText(text, true);
        javaMailSender.send(message);
    }
}
