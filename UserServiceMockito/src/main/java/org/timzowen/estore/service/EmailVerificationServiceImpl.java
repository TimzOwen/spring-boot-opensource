package org.timzowen.estore.service;

import org.timzowen.estore.model.User;

public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Override
    public void scheduleEmailVerification(User user) {
        // Doing tests soon....
        System.out.println("ScheduledEmailVerification is called...");
    }
}
