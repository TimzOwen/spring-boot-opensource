package org.timzowen;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedIndexLifyClycleTest {

    StringBuilder completed = new StringBuilder("");

    @AfterEach
    void afterEach(){
        System.out.println("The state Instance of object is: " + completed);
    }

    @Order(1)
    @Test
    void testD(){
        System.out.println("Testing method D");
        completed.append("1");
    }
    @Test
    void testA(){
        System.out.println("Testing method A");
        completed.append("4");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("Testing method C");
        completed.append("2");
    }

    @Order(3)
    @Test
    void testB(){
        System.out.println("Testing method B");
        completed.append("3");
    }


}
