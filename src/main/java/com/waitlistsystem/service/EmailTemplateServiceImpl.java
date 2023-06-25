
package com.waitlistsystem.service;

import com.waitlistsystem.entity.EmailTemplate;
import com.waitlistsystem.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

    private final EmailTemplateRepository emailTemplateRepository;

    @Autowired
    public EmailTemplateServiceImpl(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    @Override
    public List<EmailTemplate> getAllEmailTemplates() {
        return emailTemplateRepository.findAll();
    }

    @Override
    public EmailTemplate addEmailTemplate(EmailTemplate emailTemplate) {
        return emailTemplateRepository.save(emailTemplate);
    }

    @Override
    public EmailTemplate getEmailTemplate(Long id) {
        return emailTemplateRepository.findById(id).orElse(null);
    }
}
