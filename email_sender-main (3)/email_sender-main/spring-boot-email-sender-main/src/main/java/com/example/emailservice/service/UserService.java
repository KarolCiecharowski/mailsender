package emailservice.service;

import emailservice.model.Email;
import emailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
