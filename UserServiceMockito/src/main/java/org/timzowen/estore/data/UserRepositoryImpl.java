package org.timzowen.estore.data;

import org.timzowen.estore.model.User;

import java.util.HashMap;

public class UserRepositoryImpl implements UserRepository {

    HashMap<String, User> userHashMap = new HashMap<>();
    @Override
    public boolean save(User user) {

        boolean returnValue = false;

        if (!userHashMap.containsKey(user.getId())){
            userHashMap.put(user.getId(), user);
            returnValue = true;
        }

        return returnValue;
    }
}
