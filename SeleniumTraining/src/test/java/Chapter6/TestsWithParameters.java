package Chapter6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestsWithParameters {

    @ParameterizedTest(name = "TC1 - Test even numbers: {arguments}")
    @ValueSource(ints = {50, 14, 23, 9, 81})
    void testEvenNumbers(int number){
        boolean expected = true;

        boolean actual = (number % 2 == 0);

        assertEquals(expected, actual, number + " is not an even number");
    }

    @ParameterizedTest(name = "TC2 - Check high price increase:  {arguments}")
    @ValueSource(doubles = {10.55, 15.50, 82, 65.99})
    void testHighPriceIncrease(double price){
        //Arrange
        boolean expected = true;
        double percentage = 0.15;
        //Actual
        double priceIncrease = price * percentage;
        boolean actual = (priceIncrease > 5);
        //Assert
        assertEquals(expected, actual, "Price increase of " + priceIncrease + " is less than 5");
    }
    /*Loan is approved when a person is >= 18 and employed, salary >=10 000
    firstname, lastname, age, salary, isEmployed?
     */
    @ParameterizedTest(name = "TC3 - Loan Approval: {arguments}")
    @CsvSource(value = {"John,Smith,35,15000.00,true","Jessica,Jones,26,10000.00,true","Carol,Jackson,20,7500.00,true"})
    void testLoanApproval(String firstname, String lastname, int age, double salary, boolean isEmployed){
        System.out.println("firstname = " + firstname + ", lastname = " + lastname + ", age = "
                + age + ", salary = " + salary + ", isEmployed = " + isEmployed);

        boolean expected = true;

        boolean actual = (age >=18 && salary >= 10000 && isEmployed);

        assertEquals(expected, actual,
                "Declined... You must be 18yrs (" + age + ")  or older, and you must be employed," +
                        " earning R10 000 (" + salary + ") or more");
    }

    @ParameterizedTest(name = "TC4 - Check Students who passed: {arguments}")
    @CsvFileSource(files = "src/test/resources/Students.csv",numLinesToSkip = 1)
    void verifyPassMark(String stNumber, String firstname, String lastname, String module, int testScore){
       // System.out.println("stNumber = " + stNumber + ", firstname = " + firstname + ", lastname = " + lastname + ", module = " + module + ", testScore = " + testScore);

        assertTrue(testScore >= 65);
    }


}
