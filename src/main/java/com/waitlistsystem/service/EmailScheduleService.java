
package com.waitlistsystem.service;

import com.waitlistsystem.entity.EmailSchedule;
import com.waitlistsystem.repository.EmailScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailScheduleService {

    private final EmailScheduleRepository emailScheduleRepository;

    @Autowired
    public EmailScheduleService(EmailScheduleRepository emailScheduleRepository) {
        this.emailScheduleRepository = emailScheduleRepository;
    }

    public List<EmailSchedule> getAllEmailSchedules() {
        return emailScheduleRepository.findAll();
    }

    public EmailSchedule getEmailSchedule(Long id) {
        return emailScheduleRepository.findById(id).orElse(null);
    }

    public EmailSchedule addEmailSchedule(EmailSchedule emailSchedule) {
        return emailScheduleRepository.save(emailSchedule);
    }

    public EmailSchedule updateEmailSchedule(Long id, EmailSchedule emailSchedule) {
        EmailSchedule existingEmailSchedule = emailScheduleRepository.findById(id).orElse(null);
        if (existingEmailSchedule != null) {
            existingEmailSchedule.setTemplateName(emailSchedule.getTemplateName());
            existingEmailSchedule.setSchedule(emailSchedule.getSchedule());
            return emailScheduleRepository.save(existingEmailSchedule);
        }
        return null;
    }

    public void deleteEmailSchedule(Long id) {
        emailScheduleRepository.deleteById(id);
    }
}
