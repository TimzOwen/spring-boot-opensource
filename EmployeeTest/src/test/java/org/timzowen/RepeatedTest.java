package org.timzowen;

import org.junit.jupiter.api.*;

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
    void TestingArithmeticOperation(RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
        int num1 = 4, num2 = 0;
        String expectedMessage = "/ by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            employee.subtractionClass(num1,num2);
        },"Zero should throw an exception");
        assertEquals(expectedMessage, actualException.getMessage(), "Unexpected exception caught.");
    }

}
