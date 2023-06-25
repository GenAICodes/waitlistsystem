
package com.waitlistsystem.service;

import com.waitlistsystem.entity.EmailTemplate;
import com.waitlistsystem.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService {

    private final EmailTemplateRepository emailTemplateRepository;

    @Autowired
    public EmailTemplateService(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    public EmailTemplate getEmailTemplate(String templateName) {
        return emailTemplateRepository.findByTemplateName(templateName);
    }

    public EmailTemplate addEmailTemplate(EmailTemplate emailTemplate) {
        return emailTemplateRepository.save(emailTemplate);
    }

    public EmailTemplate updateEmailTemplate(EmailTemplate emailTemplate) {
        return emailTemplateRepository.save(emailTemplate);
    }

    public void deleteEmailTemplate(String templateName) {
        EmailTemplate emailTemplate = emailTemplateRepository.findByTemplateName(templateName);
        emailTemplateRepository.delete(emailTemplate);
    }
}
