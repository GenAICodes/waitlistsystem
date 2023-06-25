
package com.waitlistsystem.notification;

public class EmailTemplate {
    public static String getWaitlistNotificationEmail(String name, int rank) {
        String html = "<html><body>";
        html += "<h2>Waitlist Notification</h2>";
        html += "<p>Dear " + name + ",</p>";
        html += "<p>Your turn has come up in the waitlist. You are currently at position " + rank + ".</p>";
        html += "<p>Thank you for your patience.</p>";
        html += "</body></html>";
        return html;
    }
}
