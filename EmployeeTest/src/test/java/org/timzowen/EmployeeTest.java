package org.timzowen;

import org.junit.jupiter.api.*;

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

    @Test
    @DisplayName("4 - 2 == 2")
    void CalculateTSubtractionOfTwoNumbersTest() {
        System.out.println("Running division method....");
        int num1 = 4;
        int num2 = 0;
        String expectedMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class,()-> {
             employee.subtractionClass(num1, num2);
        },"Division by 0 not allowed");
        assertEquals(expectedMessage,  actualException.getMessage(),"unexpected exception error");
    }

}