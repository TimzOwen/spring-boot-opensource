package org.timzowen.estore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.timzowen.estore.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @DisplayName("User Object creation")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject(){
        //Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "Timz";
        String lastName = "Owen";
        String email = "owen@gmail.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);

        // Assert
        assertNotNull(user, "createUser method should not have returned null" );
        assertEquals(firstName,user.getFirstName(),"FirstName not matching user input");
        assertEquals(lastName,user.getLastName(),"lastName not matching user input");
        assertEquals(email,user.getEmail(),"User Email not matching user input");
        assertNotNull(user.getId(),"User Id is missing");
    }

    @DisplayName("Empty firstName Throw exception")
    @Test
    void testCreateUser_WhenFirstNameIsEmpty_throwsIllegalArgsException(){
        UserService userService = new UserServiceImpl();
        String firstName = "";
        String lastName = "Owen";
        String email = "owen@gmail.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty first Name shout throw an exception");
    }

}
