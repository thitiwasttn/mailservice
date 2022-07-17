package com.thitiwas.mailservice.controller;

import com.thitiwas.mailservice.model.MailRequest;
import com.thitiwas.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/mail")
public class MailController {
    private final EmailService emailService;

    @Autowired
    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> findById(@RequestBody MailRequest mailRequest) {
        emailService.send(mailRequest);
        return ResponseEntity.ok().body(null);
    }
}
