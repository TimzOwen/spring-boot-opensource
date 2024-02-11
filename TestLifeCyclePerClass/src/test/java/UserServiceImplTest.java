import org.junit.jupiter.api.*;
import org.timzowen.io.UsersDatabase;
import org.timzowen.io.UsersDatabaseMapImpl;
import org.timzowen.service.UserService;
import org.timzowen.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {
    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId = "";

    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);

    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        // Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName","Timz");
        user.put("lastName","Owen");

        // Act
        createdUserId = userService.createUser(user);

        // Assert
        assertNotNull(createdUserId,"User Id should not be null");
    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        // Arrange
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName","Timothy");
        newUserDetails.put("lastName","Owen");

        // Act
        Map updateUserDetails = userService.updateUser(createdUserId,newUserDetails);

        //assert
        assertEquals(newUserDetails.get("firstName"), updateUserDetails.get("firstName"),"Returned First name is incorrect");
        assertEquals(newUserDetails.get("lastName"),updateUserDetails.get("lastName"),"Returned LastName is incorrect");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        Map userDetails = userService.getUserDetails(createdUserId);

        //Assert
        assertNotNull(userDetails, "User details should not be null");
        assertEquals(createdUserId,userDetails.get("userId"),"Returned incorrect user details.");


    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        userService.deleteUser(createdUserId);

        //Assert
        assertNull(userService.getUserDetails(createdUserId),"User should not be found ");
    }
}
