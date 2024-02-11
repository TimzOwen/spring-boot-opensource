package org.timzowen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeAll
    static void setupTests() {
        System.out.println("Running @Before all Test ..........");
    }

    @AfterAll
    static void cleanupTest() {
        System.out.println("Cleaning up open resources @after all test....... ");
    }

    @BeforeEach
    void beforeEachMethodTest(){
        employee = new Employee();
        System.out.println("@Before each method just got executed........");
    }

    @AfterEach
    void afterEachMethodTest(){
        System.out.println("@After each method getting executed........");
    }

    @Test
    @DisplayName("salary against time")
    void calculateSalaryExpectationBasedOnRatesAgainstTimeTest() {
        System.out.println("Running Salary test method");
        int expectedSalary = employee.calculateSalaryEmployee(30, 100);
        assertEquals(3000, expectedSalary);
    }


//    // Testing input with multiple parameters.
//    //--> Method name can be same as the unit test name. Method source won't need naming.
//    @DisplayName("Test method, num1, num2, expectedResults")
//    @ParameterizedTest
//    @MethodSource
//    void subtractionOfTwoNumbers(int num1, int num2, int expectedResults) {
//        System.out.println("Running " + num1 + " - " + num2 + " = " + expectedResults);
//        int actualResult = employee.calculateSalaryEmployee(num1, num2);
//        assertEquals(expectedResults,actualResult, ()->
//            num1 + " - " +  num2 + " did not return " + expectedResults);
//    }
//
//    private static Stream<Arguments> subtractionOfTwoNumbers(){
//        return Stream.of(
//                Arguments.of(33,2,31),
//                Arguments.of(20,10,10),
//                Arguments.of(15,10,5)
//        );
//    }

//
//  // Using multiple params [ csv Source annotation]
//    @DisplayName("Test method, num1, num2, expectedResults")
//    @ParameterizedTest
//    @CsvSource({
//            "22, 1, 21",
//             "33,3,30",
//            "45,5,40"})
//    void subtractionOfTwoNumbers(int num1, int num2, int expectedResults) {
//        System.out.println("Running " + num1 + " - " + num2 + " = " + expectedResults);
//        int actualResult = employee.calculateSalaryEmployee(num1, num2);
//        assertEquals(expectedResults,actualResult, ()->
//                num1 + " - " +  num2 + " did not return " + expectedResults);
//    }

    // Value Source parameter
    @ParameterizedTest
    @ValueSource(strings = {"Timz","Owen","James"})
    void valueSourceTest(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.5,4.7,6.8,7.9,10.8})
    void valueSourceIntsTest(double salary){
        System.out.println(salary);
//        assertNotNull(salary); // ints / doubles are never null so no need.
    }


  // Using multiple params [ from a csv file]
    @DisplayName("Test method, num1, num2, expectedResults")
    @ParameterizedTest
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void subtractionOfTwoNumbers(int num1, int num2, int expectedResults) {
        System.out.println("Running " + num1 + " - " + num2 + " = " + expectedResults);
        int actualResult = employee.calculateSalaryEmployee(num1, num2);
        assertEquals(expectedResults,actualResult, ()->
                num1 + " - " +  num2 + " did not return " + expectedResults);
    }

    private static Stream<Arguments> subtractionOfTwoNumbers(){
        return Stream.of(
                Arguments.of(33,2,31),
                Arguments.of(20,10,10),
                Arguments.of(15,10,5)
        );
    }

    // ---> This line below doesn't accept input parameters
//    @Test
//    @DisplayName("4 - 2 == 2")
//    void CalculateTSubtractionOfTwoNumbersTest() {
//        System.out.println("Running division method....");
//        int num1 = 4;
//        int num2 = 0;
//        String expectedMessage = "/ by zero";
//        ArithmeticException actualException = assertThrows(ArithmeticException.class,()-> {
//            employee.subtractionClass(num1, num2);
//        },"Division by 0 not allowed");
//        assertEquals(expectedMessage,  actualException.getMessage(),"unexpected exception error");
//    }

}