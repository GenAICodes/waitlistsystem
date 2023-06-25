
package com.waitlistsystem.controller;

import com.waitlistsystem.entity.EmailTemplate;
import com.waitlistsystem.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email_templates")
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    @Autowired
    public EmailTemplateController(EmailTemplateService emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    @GetMapping
    public ResponseEntity<List<EmailTemplate>> getAllEmailTemplates() {
        List<EmailTemplate> emailTemplates = emailTemplateService.getAllEmailTemplates();
        return ResponseEntity.ok(emailTemplates);
    }

    @PostMapping
    public ResponseEntity<EmailTemplate> addEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
        EmailTemplate addedEmailTemplate = emailTemplateService.addEmailTemplate(emailTemplate);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmailTemplate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailTemplate> getEmailTemplate(@PathVariable Long id) {
        EmailTemplate emailTemplate = emailTemplateService.getEmailTemplate(id);
        return ResponseEntity.ok(emailTemplate);
    }
}
