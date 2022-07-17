package com.thitiwas.mailservice.controller;

import com.thitiwas.mailservice.model.MailRequest;
import com.thitiwas.mailservice.model.ResponseObj;
import com.thitiwas.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/api/mail")
public class MailController {
    private final EmailService emailService;

    @Autowired
    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseObj<String>> sendMail(@RequestBody MailRequest mailRequest) {
        emailService.send(mailRequest);
        return ResponseEntity.ok().body(ResponseObj.<String>builder()
                .message("")
                .status(HttpStatus.OK.value())
                .timeStamp(Calendar.getInstance().getTime().getTime())
                .objects(List.of())
                .build());
    }
}
