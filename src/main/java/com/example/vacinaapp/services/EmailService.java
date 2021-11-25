package com.example.vacinaapp.services;

import com.example.vacinaapp.enums.StatusEmail;
import com.example.vacinaapp.models.Email;
import com.example.vacinaapp.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;


    public ResponseEntity sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException ex) {

            email.setStatusEmail(StatusEmail.ERROR);
            return ResponseEntity.badRequest().body(ex.getMessage());
        } finally {
            return ResponseEntity.ok().body(emailRepository.save(email));
        }
    }

    public ResponseEntity findEmails() {
        try {
            return ResponseEntity.ok().body(emailRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
