
package com.waitlistsystem.repository;

import com.waitlistsystem.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    EmailTemplate findByTemplateName(String templateName);
}
