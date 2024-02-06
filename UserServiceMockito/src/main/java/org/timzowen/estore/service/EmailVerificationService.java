package org.timzowen.estore.service;

import org.timzowen.estore.model.User;

public interface EmailVerificationService {

    void scheduleEmailVerification(User user);
}
