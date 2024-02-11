package com.appsdeveloperblog.tutorials.junit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserEntityIntegrationTest {
    private UserEntity userEntity;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setup(){
        userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setFirstName("Timz");
        userEntity.setLastName("Owen");
        userEntity.setEmail("timz@gmail.com");
        userEntity.setEncryptedPassword("12345678");

    }

    @Test
    void testUserEntity_whenValidUserDetailsProvided_shouldReturnUserDetails(){
        // Arrange & Act
        UserEntity storedUserEntityManager = testEntityManager.persistAndFlush(userEntity);

        // assert
        Assertions.assertTrue(storedUserEntityManager.getId()>0);
        Assertions.assertEquals(userEntity.getUserId(),storedUserEntityManager.getUserId());
        Assertions.assertEquals(userEntity.getFirstName(),storedUserEntityManager.getFirstName());
        Assertions.assertEquals(userEntity.getLastName(),storedUserEntityManager.getLastName());
        Assertions.assertEquals(userEntity.getEmail(),storedUserEntityManager.getEmail());
        Assertions.assertEquals(userEntity.getEncryptedPassword(),storedUserEntityManager.getEncryptedPassword());
    }

    @Test
    void testUserEntity_whenFirstNameTooLong_shouldThrowException(){
        // Arrange
        userEntity.setFirstName("TimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimzTimz");

        //Act & assert
        assertThrows(PersistenceException.class,()->{
            testEntityManager.persistAndFlush(userEntity);
        },"Expected Persistence Exception to tbe thrown");
    }

    @Test
    void testUserEntity_whenDuplicateUserIdExist_shouldThrowException(){
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUserId("1");
        newUserEntity.setFirstName("Timz");
        newUserEntity.setLastName("Owen");
        newUserEntity.setEmail("timz@gmail.com");
        newUserEntity.setEncryptedPassword("12345678");
        testEntityManager.persistAndFlush(newUserEntity);

        userEntity.setUserId("1");

        assertThrows(PersistenceException.class, ()-> {
            testEntityManager.persistAndFlush(userEntity);
        },"Expected Persistence Exception to be throw.");
    }

}
