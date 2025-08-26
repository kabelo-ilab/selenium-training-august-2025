package Chapter6;

import org.junit.jupiter.api.*;

/**
 * This class demonstrate the use of different annotations
 * from JUnit 5's library
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {

    @BeforeAll
    static void setup(){
        System.out.println("----------Setup--------------");
    }

    @AfterAll
    static void teardown(){
        System.out.println("***********Post Execution*************");
    }
    @BeforeEach
    void beforeTestCase(){
        System.err.println("Before Each...");
    }

    @AfterEach
    void afterTestCase(){
        System.out.println("===== After Each =====");
    }
    @Test
    @DisplayName("TC1 - First Test")
    @Order(1)
    @Tag("Sanity")
    void firstTest(){
        System.out.println("First test method");
    }

    @Test
    @DisplayName("TC2 - Second Test")
    @Order(2)
    @Tag("Sanity")
    @Tag("Performance")
    void secondTest(){
        System.out.println("Second test method");
    }

    @Test
    @DisplayName("TC3 - Third Test")
    @Order(3)
    @Tag("Load")
    @Tag("Regression")
    void thirdTest(){
        System.out.println("Third Test method");
    }

}
