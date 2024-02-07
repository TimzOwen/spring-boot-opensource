package com.appsdeveloperblog.tutorials.junit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.UUID;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UsersRepository usersRepository;

    UserEntity userEntity;

    @BeforeEach
    void setup(){
        userEntity= new UserEntity();
        userEntity.setUserId("12");
        userEntity.setFirstName("Timz");
        userEntity.setLastName("Owen");
        userEntity.setEmail("timz@gmail.com");
        userEntity.setEncryptedPassword("12345678");
    }

    @Test
    void testFindByEmail_whenCorrectEmailProvided_returnUserEntity(){
        // Arrange & Act
        UserEntity savedUser = testEntityManager.persistAndFlush(userEntity);

        Assertions.assertEquals(savedUser.getEmail(),userEntity.getEmail(),"Provided Email did not match expected Email");
    }

    @Test
    void testFindById_whenRightUserEntityIdProvided_returnUserEntityObject(){
        //Arrange
        testEntityManager.persistAndFlush(userEntity);

        //act
        UserEntity savedUser = usersRepository.findByUserId(userEntity.getUserId());

        //assert
        Assertions.assertEquals(savedUser.getUserId(),userEntity.getUserId(),"Should throw Exception no such user Id");

    }
}
