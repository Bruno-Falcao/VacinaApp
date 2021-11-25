package com.example.vacinaapp.controllers;

import com.example.vacinaapp.dtos.EmailDto;
import com.example.vacinaapp.models.Email;
import com.example.vacinaapp.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        try {
            Email email = new Email();
            BeanUtils.copyProperties(emailDto, email);
            return emailService.sendEmail(email);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("find-emails")
    public ResponseEntity findEmails() {
        try {
            return emailService.findEmails();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
