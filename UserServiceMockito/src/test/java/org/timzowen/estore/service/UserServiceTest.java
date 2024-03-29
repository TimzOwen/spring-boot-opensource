package org.timzowen.estore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.timzowen.estore.data.UserRepository;
import org.timzowen.estore.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    EmailVerificationServiceImpl emailVerificationService;
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
        Mockito.when(userRepository.save(any(User.class))).thenReturn(true);

        // Act
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);

        // Assert
        assertNotNull(user, "createUser method should not have returned null" );
        assertEquals(firstName,user.getFirstName(),"FirstName not matching user input");
        assertEquals(lastName,user.getLastName(),"lastName not matching user input");
        assertEquals(email,user.getEmail(),"User Email not matching user input");
        assertNotNull(user.getId(),"User Id is missing");

        // Verify method calls
        Mockito.verify(userRepository).save(any(User.class));
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

    @Test
    @DisplayName("save() causes Runtime, userServiceException thrown")
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException(){
        String expectedMessage = "user's first name is empty";
        //Arrange
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        //Act
        assertThrows(UserServiceException.class,()->{
            userService.createUser(firstName,lastName,email,password, repeatPassword);
        },"Should have thrown userServiceException instead");
    }

    @Test
    @DisplayName("EmailNotificationException handled.")
    void testCreateUser_WhenEmailNotificationExceptionThrown_throwUserServiceException(){
        //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);

        doThrow(EmailNotificationException.class)
                .when(emailVerificationService)
                .scheduleEmailVerification(any(User.class));
        // Do nothing
        //  doNothing().when(emailVerificationService).scheduleEmailVerification(any(User.class));

        //Act & assert
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Should have thrown UserServiceException instead");

        // Assert
        verify(emailVerificationService, times(1))
                .scheduleEmailVerification(any(User.class));
    }

    @DisplayName("Schedule Email confirmation is executed.")
    @Test
    void testCreateUser_whenUserCreated_scheduleEmailConfirmation(){
        // Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);

        doCallRealMethod().when(emailVerificationService).scheduleEmailVerification(any(User.class));

        //Act
        userService.createUser(firstName,lastName,email,password,repeatPassword);

        //assert
        verify(emailVerificationService,times(1)).scheduleEmailVerification(any(User.class));
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
