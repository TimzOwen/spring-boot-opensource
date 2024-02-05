package org.timzowen;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedIndexTest {

    @Order(1)
    @Test
    void testD(){
        System.out.println("Testing method D");
    }
    @Test
    void testA(){
        System.out.println("Testing method A");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("Testing method C");
    }

    @Order(3)
    @Test
    void testB(){
        System.out.println("Testing method B");
    }


}
