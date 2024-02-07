package com.appsdeveloperblog.tutorials.junit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.UUID;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    private UsersRepository usersRepository;

    private final String userId1 = UUID.randomUUID().toString();
    private final String userId2 = UUID.randomUUID().toString();
    private final String email1 = "test@email1.com";
    private final String email2 = "test@email2.com";

    @BeforeEach
    void setup(){
        UserEntity userEntity= new UserEntity();
        userEntity.setUserId(userId1);
        userEntity.setFirstName("Timz");
        userEntity.setLastName("Owen");
        userEntity.setEmail(email1);
        userEntity.setEncryptedPassword("12345678");
        testEntityManager.persistAndFlush(userEntity);

        UserEntity userEntity2= new UserEntity();
        userEntity2.setUserId(userId2);
        userEntity2.setFirstName("Timz");
        userEntity2.setLastName("Owen");
        userEntity2.setEmail(email2);
        userEntity2.setEncryptedPassword("12345678");
        testEntityManager.persistAndFlush(userEntity2);
    }

    @Test
    void testFindByEmail_whenCorrectEmailProvided_returnUserEntity(){
        // Arrange & Act
        UserEntity storedUser = usersRepository.findByEmail(email1);
        Assertions.assertEquals(email1,storedUser.getEmail(),"Provided Email did not match expected Email");
    }

    @Test
    void testFindById_whenRightUserEntityIdProvided_returnUserEntityObject(){

        UserEntity savedUser = usersRepository.findByUserId(userId2);

        Assertions.assertNotNull(savedUser,"Entity object should not be null");
        Assertions.assertEquals(userId2,savedUser.getUserId(),"Returned userId does not match expected Id");

    }

    @Test
    void testFindUserWithEmailEnds_whenGivenEmailDomain_returnUserWithGivenDomain(){
        UserEntity userEntity= new UserEntity();
        userEntity.setUserId("11");
        userEntity.setFirstName("Timz");
        userEntity.setLastName("Owen");
        userEntity.setEmail("timz@gmail.com");
        userEntity.setEncryptedPassword("12345678");

        testEntityManager.persistAndFlush(userEntity);

        String emailDomainName = "@gmail.com";

        List<UserEntity> users = usersRepository.findUserWithEmailEndingWith(emailDomainName);

        Assertions.assertEquals(1,users.size(),"There should be only one user");
        Assertions.assertTrue(users.get(0).getEmail().endsWith(emailDomainName));

    }
}
