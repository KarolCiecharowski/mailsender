package emailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import emailservice.repository.EmailRepository;
import emailservice.model.Email;

import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email getEmailById(Long id) {
        return emailRepository.findById(id).orElseThrow(() -> new RuntimeException("Email not found"));
    }

    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    public Email updateEmail(Long id, Email email) {
        Email existingEmail = emailRepository.findById(id).orElseThrow(() -> new RuntimeException("Email not found"));
        existingEmail.setSubject(email.getSubject());
        existingEmail.setText(email.getText());
        existingEmail.setEmail(email.getEmail());
        return emailRepository.save(existingEmail);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }

    public void sendEmail(String subject, String text, List<String> recipients) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(text);
        message.setTo(recipients.toArray(new String[0]));
        javaMailSender.send(message);
    }

    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        message.setTo(email.getEmail());
        javaMailSender.send(message);
    }

}