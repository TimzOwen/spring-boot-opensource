package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import com.appsdeveloperblog.tutorials.junit.ui.response.UserRest;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.AssertFalse;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "/application-test.properties",
//properties = "server.port=8082")
public class UsersControllerIntegrationTest{

    @Value("${server.port}")
    private int serverPort;

    @LocalServerPort
    private int localServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

   @Test
   @DisplayName("user can be created")
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
}
