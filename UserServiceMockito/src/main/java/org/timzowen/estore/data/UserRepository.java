package org.timzowen.estore.data;

import org.timzowen.estore.model.User;

public interface UserRepository {
    boolean save(User user);
}
