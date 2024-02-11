package org.timzowen;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodOrderNameTest {
    @Test
    void testA(){
        System.out.println("Testing method A");
    }

    @Test
    void testB(){
        System.out.println("Testing method B");
    }

    @Test
    void testC(){
        System.out.println("Testing method C");
    }

    @Test
    void testD(){
        System.out.println("Testing method D");
    }
}
