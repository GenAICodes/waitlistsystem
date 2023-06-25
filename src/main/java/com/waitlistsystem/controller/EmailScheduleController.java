
package com.waitlistsystem.controller;

import com.waitlistsystem.entity.EmailSchedule;
import com.waitlistsystem.service.EmailScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email_schedules")
public class EmailScheduleController {

    private final EmailScheduleService emailScheduleService;

    @Autowired
    public EmailScheduleController(EmailScheduleService emailScheduleService) {
        this.emailScheduleService = emailScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<EmailSchedule>> getAllEmailSchedules() {
        List<EmailSchedule> emailSchedules = emailScheduleService.getAllEmailSchedules();
        return ResponseEntity.ok(emailSchedules);
    }

    @PostMapping
    public ResponseEntity<EmailSchedule> addEmailSchedule(@RequestBody EmailSchedule emailSchedule) {
        EmailSchedule addedEmailSchedule = emailScheduleService.addEmailSchedule(emailSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmailSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailSchedule> getEmailSchedule(@PathVariable Long id) {
        EmailSchedule emailSchedule = emailScheduleService.getEmailSchedule(id);
        return ResponseEntity.ok(emailSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailSchedule> updateEmailSchedule(@PathVariable Long id, @RequestBody EmailSchedule emailSchedule) {
        EmailSchedule updatedEmailSchedule = emailScheduleService.updateEmailSchedule(id, emailSchedule);
        return ResponseEntity.ok(updatedEmailSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmailSchedule(@PathVariable Long id) {
        emailScheduleService.deleteEmailSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
