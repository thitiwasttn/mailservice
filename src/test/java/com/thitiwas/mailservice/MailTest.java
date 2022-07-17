package com.thitiwas.mailservice;


import com.thitiwas.mailservice.model.MailRequest;
import com.thitiwas.mailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MailServiceApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class MailTest {

    @Autowired
    private EmailService emailService;

    @Before
    public void setUp() throws Exception {
        log.debug("===== test mail =====");
    }

    interface TestData {
        String to = "twopee26@gmail.com";
        String subject = "Hello";
        String message = "hi there!!";
    }

    @Test
    public void testSendMail() {
        MailRequest mailRequest = MailRequest.builder()
                .to(TestData.to)
                .subject(TestData.subject)
                .message(TestData.message)
                .build();
        emailService.send(mailRequest);
    }
}
