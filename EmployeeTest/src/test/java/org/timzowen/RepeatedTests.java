package org.timzowen;

import org.junit.jupiter.api.BeforeEach;

public class RepeatedTests {

    Employee employee;

    @BeforeEach
    void beforeEachTest(){
        employee = new Employee();
        System.out.println("Executing before each method.....");
    }



}
