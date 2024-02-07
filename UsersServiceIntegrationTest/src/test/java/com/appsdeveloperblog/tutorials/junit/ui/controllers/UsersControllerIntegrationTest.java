package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "/application-test.properties",
properties = "server.port=8082")
public class UsersControllerIntegrationTest {

    @Value("${server.port}")
    private int serverPort;

    @Test
    void contextLoads(){
        System.out.println(" defining port in properties and using @SBT annotation");
        System.out.println("server port: " + serverPort);
    }
}
