package org.riskfirst.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMovementFormNotification(MovementFormData formData) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rob@kite9.com");
        message.setSubject("New Movement Form Submission - Risk-First");

        String emailBody = String.format(
                "A new movement form has been submitted!\n\n" +
                        "Email: %s\n" +
                        "Social Link: %s\n\n" +
                        "This person has shared the Risk-First movement and is requesting their free copy of the book.",
                formData.getEmail(),
                formData.getSocialLink());

        message.setText(emailBody);
        message.setFrom("noreply@riskfirst.org");

        mailSender.send(message);
    }
}
