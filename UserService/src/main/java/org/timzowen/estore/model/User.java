package org.timzowen.estore.model;

public class User {
    String firstName,lastName,email,password,repeatPassword;

    public User(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }
}
