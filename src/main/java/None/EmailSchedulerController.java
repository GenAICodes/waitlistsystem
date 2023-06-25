
@RestController
@RequestMapping("/schedule_email")
public class EmailSchedulerController {

    private final WaitlistEmailService waitlistEmailService;

    @Autowired
    public EmailSchedulerController(WaitlistEmailService waitlistEmailService) {
        this.waitlistEmailService = waitlistEmailService;
    }

    @PostMapping
    public ResponseEntity<String> scheduleEmail(@RequestBody EmailDetails emailDetails) {
        waitlistEmailService.scheduleWaitlistNotificationEmail(emailDetails.getRecipientEmail(), emailDetails.getRecipientName(), emailDetails.getPosition(), emailDetails.getScheduledTime(), emailDetails.getEmailTemplate());
        return ResponseEntity.status(HttpStatus.CREATED).body("Email scheduled successfully");
    }

    public static class EmailDetails {
        private String recipientEmail;
        private String recipientName;
        private int position;
        private LocalDateTime scheduledTime;
        private String emailTemplate;

        public String getRecipientEmail() {
            return recipientEmail;
        }

        public void setRecipientEmail(String recipientEmail) {
            this.recipientEmail = recipientEmail;
        }

        public String getRecipientName() {
            return recipientName;
        }

        public void setRecipientName(String recipientName) {
            this.recipientName = recipientName;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public LocalDateTime getScheduledTime() {
            return scheduledTime;
        }

        public void setScheduledTime(LocalDateTime scheduledTime) {
            this.scheduledTime = scheduledTime;
        }

        public String getEmailTemplate() {
            return emailTemplate;
        }

        public void setEmailTemplate(String emailTemplate) {
            this.emailTemplate = emailTemplate;
        }
    }
}
