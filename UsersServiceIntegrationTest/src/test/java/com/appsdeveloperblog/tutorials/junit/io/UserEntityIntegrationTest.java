package com.appsdeveloperblog.tutorials.junit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.UUID;

@DataJpaTest
public class UserEntityIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testUserEntity_whenValidUserDetailsProvided_shouldReturnUserDetails(){
        // Arrange
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setFirstName("Timz");
        userEntity.setLastName("Owen");
        userEntity.setEmail("timz@gmail.com");
        userEntity.setEncryptedPassword("12345678");

        // Act
        UserEntity storedUserEntityManager = testEntityManager.persistAndFlush(userEntity);

        // assert
        Assertions.assertTrue(storedUserEntityManager.getId()>0);
        Assertions.assertEquals(userEntity.getUserId(),storedUserEntityManager.getUserId());
        Assertions.assertEquals(userEntity.getFirstName(),storedUserEntityManager.getFirstName());
        Assertions.assertEquals(userEntity.getLastName(),storedUserEntityManager.getLastName());
        Assertions.assertEquals(userEntity.getEmail(),storedUserEntityManager.getEmail());
        Assertions.assertEquals(userEntity.getEncryptedPassword(),storedUserEntityManager.getEncryptedPassword());

    }
}
