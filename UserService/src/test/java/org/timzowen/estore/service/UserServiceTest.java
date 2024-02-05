package org.timzowen.estore.service;

import org.junit.jupiter.api.Test;
import org.timzowen.estore.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

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
    }

    @Test
    void testCreateUser_WhenUserCreated_ReturnCorrectFirstName(){
        UserService userService = new UserServiceImpl();
        // Arrange
        String firstName = "Timz";
        String lastName = "Owen";
        String email = "owen@gmail.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        //Act
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);

        //Assert
        assertEquals(firstName, user.getFirstName(), "First name not matching");
    }

}
