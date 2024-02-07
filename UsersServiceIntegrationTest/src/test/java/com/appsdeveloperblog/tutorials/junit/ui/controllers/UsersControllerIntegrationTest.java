package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import com.appsdeveloperblog.tutorials.junit.security.SecurityConstants;
import com.appsdeveloperblog.tutorials.junit.ui.response.UserRest;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "/application-test.properties",
//properties = "server.port=8082")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersControllerIntegrationTest{

    @Value("${server.port}")
    private int serverPort;

    @LocalServerPort
    private int localServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

   @Test
   @DisplayName("user can be created")
   @Order(1)
    void testCreateUser_whenValidDetailsProvided_returnsUserDetails() throws JSONException {
       //Arrange
       JSONObject userDetailsRequestJson = new JSONObject();
       userDetailsRequestJson.put("firstName","Timz");
       userDetailsRequestJson.put("lastName","Owen");
       userDetailsRequestJson.put("email","timz@gmail.com");
       userDetailsRequestJson.put("password","12345678");
       userDetailsRequestJson.put("repeatPassword","12345678");

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

       HttpEntity<String> request = new HttpEntity<>(userDetailsRequestJson.toString(), headers);

       // Act
       ResponseEntity<UserRest> createdUserDetailsEntity = testRestTemplate.postForEntity(
               "/users",
               request,
               UserRest.class);
       UserRest createdUserDetails = createdUserDetailsEntity.getBody();

       //Assert
       Assertions.assertEquals(HttpStatus.OK, createdUserDetailsEntity.getStatusCode());
       Assertions.assertEquals(userDetailsRequestJson.getString("firstName"),
               createdUserDetails.getFirstName(),"Returned user's firstName seems to be incorrect");
       Assertions.assertEquals(userDetailsRequestJson.getString("lastName"),
               createdUserDetails.getLastName(),"Returned user's last name seems to be incorrect");
       Assertions.assertEquals(userDetailsRequestJson.getString("email"),
               createdUserDetails.getEmail(),"Returned user's email seems to be incorrect");
       Assertions.assertFalse(createdUserDetails.getUserId().trim().isEmpty(),"user Id should not be empty");
   }

   @Test
    @DisplayName("GET / users requires JWT")
   @Order(2)
    void testGetUsers_whenMissingJWT_return403(){
       // Arrange
       HttpHeaders headers = new HttpHeaders();
       headers.set("Accept","application/json");

       HttpEntity requestEntity = new HttpEntity(null,headers);

       //Act
       ResponseEntity<List<UserRest>> response = testRestTemplate.exchange("/users", HttpMethod.GET, requestEntity,
               new ParameterizedTypeReference<List<UserRest>>() {
               });

       // Assert
       Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode(),"Http status code 403 should have returned");
   }

   @Test
    @DisplayName("/Login works")
   @Order(3)
    void testUserLogin_whenCorrectCredProvided_returnJWTinAuthTokenHeader() throws JSONException {
       //Arrange
       JSONObject loginCredentials = new JSONObject();
       loginCredentials.put("email","timz@gmail.com");
       loginCredentials.put("password","12345678");

       HttpEntity<String> request = new HttpEntity<>(loginCredentials.toString());

       //Act
       ResponseEntity response = testRestTemplate.postForEntity("/users/login",request,null);

       //Assert
       Assertions.assertEquals(HttpStatus.OK,response.getStatusCode(),"Http status should be 200");
       Assertions.assertNotNull(response.getHeaders().getValuesAsList(SecurityConstants.HEADER_STRING).get(0),
               "Response should contain Authorization with JWT");
       Assertions.assertNotNull(response.getHeaders().getValuesAsList("UserID").get(0),
               "response should contain user in response header Id ");

   }

}
