package Chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This Test Class will execute test methods for the following operations:
 * Add, Subtract, Multiply, Divide
 */
public class TestAssertions {
    static int number1;
    static int number2;

    @BeforeAll
    static void setup(){
        number1 = 12;
        number2 = 4;
    }

    @Test
    @DisplayName("TC1 - Test sum")
    void testSum(){
        //Arrange - define expected inputs and outputs
        int expected = 16;

        //Actual - let the system perform the 'actual' computation
        int actual = number1 + number2 + 1;

        //Assert - compare 'expected' results with 'actual results'
        Assertions.assertEquals(expected, actual);
    }

}
