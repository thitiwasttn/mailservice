package com.thitiwas.mailservice.service;


import com.thitiwas.mailservice.model.MailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    @Value("${app.email.from}")
    private String from;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(MailRequest mailRequest) {
        send(mailRequest.getTo(), mailRequest.getSubject(), mailRequest.getMessage());
    }

    private void send(String to, String subject, String html) {
        log.debug("from :{}" , from);
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
        };
        mailSender.send(message);
    }
}
