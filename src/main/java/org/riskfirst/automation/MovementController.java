package org.riskfirst.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movement")
@CrossOrigin(origins = "*") // Allow CORS for the frontend
public class MovementController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitMovementForm(@RequestBody MovementFormData formData) {
        try {
            // Send email notification
            emailService.sendMovementFormNotification(formData);

            // Return success response
            return ResponseEntity.ok("Form submitted successfully");
        } catch (Exception e) {
            // Log the error (you might want to add proper logging here)
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing form submission");
        }
    }
}
