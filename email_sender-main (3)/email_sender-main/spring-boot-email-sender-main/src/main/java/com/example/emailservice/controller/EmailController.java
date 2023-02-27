package emailservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emailservice.model.Email;
import emailservice.repository.EmailRepository;
import emailservice.model.User;
import emailservice.repository.UserRepository;
import emailservice.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailRepository emailRepository;
    private final EmailService emailService;
    private final UserRepository userRepository;

    @Autowired
    public EmailController(EmailRepository emailRepository, EmailService emailService, UserRepository userRepository) {
        this.emailRepository = emailRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestParam String subject, @RequestParam String text) {
        List<String> emails = userRepository.findAll().stream().map(User::getEmail).collect(Collectors.toList());
        emailService.sendEmail(subject, text, emails);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Email email = emailRepository.findById(id).orElse(null);
        if (email == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(email);
        }
    }

    @PostMapping("/Add")
    public Email addEmail(@RequestBody Email email) {
        return emailRepository.save(email);
    }

    @PutMapping("/UpdateById/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email email) {
        Email existingEmail = emailRepository.findById(id).orElse(null);
        if (existingEmail == null) {
            return ResponseEntity.notFound().build();
        } else {
            existingEmail.setSubject(email.getSubject());
            existingEmail.setText(email.getText());
            emailRepository.save(existingEmail);
            return ResponseEntity.ok(existingEmail);
        }
    }

    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        Email email = emailRepository.findById(id).orElse(null);
        if (email == null) {
            return ResponseEntity.notFound().build();
        } else {
            emailRepository.delete(email);
            return ResponseEntity.ok().build();
        }
    }
}
