package org.timzowen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatedTest {

    Employee employee;

    @BeforeEach
    void beforeEachTest(){
        employee = new Employee();
        System.out.println("Executing before each method.....");
    }

    @DisplayName("Test Zero division")
    @org.junit.jupiter.api.RepeatedTest(4)
    void TestingArithmeticOperation(){
        int num1 = 4, num2 = 0;
        String expectedMessage = "/ by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            employee.subtractionClass(num1,num2);
        },"Zero should throw an exception");
        assertEquals(expectedMessage, actualException.getMessage(), "Unexpected exception caught.");
    }

}
