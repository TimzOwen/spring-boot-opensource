package org.timzowen.estore.model;

public class User {
    String id,firstName,lastName,email,password,repeatPassword;

    public User(String firstName,String lastName,String email,String id){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getId() {
        return id;
    }
}
