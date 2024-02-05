package org.timzowen.estore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.timzowen.estore.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void beforeEach(){
        firstName = "Timz";
        lastName = "Owen";
        email = "owen@gmail.com";
        password = "12345678";
        repeatPassword = "12345678";
    }

    @DisplayName("User Object creation")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject(){
        //Arrange

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
        //Arrange
        String firstName = "";
        String expectedMessage = "user's first name is empty";

        // Act & Throw
        IllegalArgumentException actualMessage = Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty first Name should throw an exception");

        //Assert
        assertEquals(expectedMessage,actualMessage.getMessage(),"Exception error message not correct.");
    }

    @DisplayName("Empty lastName throw exception")
    @Test
    void testCreateUser_WhenLastNameEmpty_ThrowIllegalArgsException(){
        //arrange
        lastName="";
        String expectedMessage = "user last name should not be empty";

        //Act & throw
        IllegalArgumentException actualMessage = Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty last name should throw illegal exception");

        // assert
        assertEquals(expectedMessage,actualMessage.getMessage(),"Exception message not correct");

    }

}
