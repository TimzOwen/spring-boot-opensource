package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import com.appsdeveloperblog.tutorials.junit.service.UsersService;
import com.appsdeveloperblog.tutorials.junit.service.UsersServiceImpl;
import com.appsdeveloperblog.tutorials.junit.shared.UserDto;
import com.appsdeveloperblog.tutorials.junit.ui.request.UserDetailsRequestModel;
import com.appsdeveloperblog.tutorials.junit.ui.response.UserRest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = UsersController.class,
excludeAutoConfiguration = {SecurityException.class})
//@AutoConfigureMockMvc(addFilters = false) --> disable security scan
//@MockBean({UsersServiceImpl.class})
public class UserControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    //@Autowired
    @MockBean
    private UsersService usersService;

    @Test
    @DisplayName("user can be created")
    void testUserCreate_whenValidUserDetailsProvided_returnsCreatedUserDetails() throws Exception {
        //Arrange
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setFirstName("Timz");
        userDetailsRequestModel.setLastName("owen");
        userDetailsRequestModel.setEmail("timz@gmail.com");
        userDetailsRequestModel.setPassword("12345678");
        userDetailsRequestModel.setRepeatPassword("12345678");

        UserDto userDto = new ModelMapper().map(userDetailsRequestModel,UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        when(usersService.createUser(any(UserDto.class))).thenReturn(userDto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userDetailsRequestModel));

        // Act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String responseBodyAsString = mvcResult.getResponse().getContentAsString();
        UserRest createdUser = new ObjectMapper().readValue(responseBodyAsString,UserRest.class);

        //Assert
        Assertions.assertEquals(userDetailsRequestModel.getFirstName(), createdUser.getFirstName(),"Returned first name incorrect");
        Assertions.assertEquals(userDetailsRequestModel.getLastName(), createdUser.getLastName(),"Returned last name incorrect");
        Assertions.assertEquals(userDetailsRequestModel.getEmail(), createdUser.getEmail(),"Returned email incorrect");
        Assertions.assertFalse(createdUser.getUserId().isEmpty(),"user Id should not be empty");


    }
}
