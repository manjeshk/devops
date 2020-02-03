package com.manjeshk.app.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * If use the TestInstance annotation, beforeAll and afterAll are not need to be static
 *
 * @DisplayName works with @Test annotation
 * @Disabled annotation is used to disable any test case
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtilsTest")
class MathUtilsTest {
    private MathUtils mathUtils;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeAll
    @DisplayName("beforeAll")
    static void beforeAll() {
        System.out.println("Before all method must be static because it runs before creating an instance of the class");
    }

    @BeforeEach
    @DisplayName("init")
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry(testInfo.getDisplayName() + " with " + testInfo.getTags() + " tag");
    }

    @Test
    @DisplayName("Addition")
    void testAdd() {
        //mathUtils = new MathUtils();

        int expected = 10;
        int actual = mathUtils.add(5, 5);
        assertEquals(expected, actual, "Test case for adding numbers");

        //Compare each elements
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {1, 2, 3, 4, 5};
        assertArrayEquals(array1, array2);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        assertIterableEquals(list1, list2, "Test case for list");
    }

    /**
     * TDD: Test driven development
     */
    @Test
    @DisplayName("CalculateCircleArea")
    @EnabledOnOs(OS.MAC)
    public void testCalculateCircleArea() {
        mathUtils = new MathUtils();
        boolean status = false;
        assumeTrue(status);
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    /**
     * assertThrows
     */
    @Test
    @DisplayName("Divide")
    @Disabled
    public void testDivide() {
        mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0), "Divide by 0 will throw ArithmeticException");
    }

    @Test
    void testAssertAll() {
        //mathUtils = new MathUtils();
        assertAll(
                () -> assertEquals(314.1592653589793, mathUtils.computeCircleArea(10)),
                () -> assertEquals(4, mathUtils.add(2, 2))
        );
    }


//    @AfterEach
//    @DisplayName("cleanup")
//    void cleanup() {
//        System.out.println("Cleanup");
//    }
//
//    @AfterAll
//    @DisplayName("afterAl")
//    void afterAl() {
//        System.out.println("After all muethod must be static because it runs before creating an instance of the class");
//    }

    /**
     * @Nested annotation is used to group the test cases
     */

    @Nested
    @DisplayName("Add method")
    class AddTests {
        @Test
        @DisplayName("Addition positive numbers")
        void testAddPositive() {
            assertEquals(10, mathUtils.add(5, 5), "Adding two positive numbers");
        }

        @Test
        @DisplayName("Addition negative numbers")
        void testAddNegative() {
            assertEquals(-10, mathUtils.add(-5, -5), "Adding two negative numbers");
        }
    }

    /**
     * This message will be computed when test case will be passed
     */
    @Test
    @DisplayName("CompareArrays")
    void testCompareArrays() {
        int expected = 10;
        int actual = mathUtils.add(5, 5);
        assertEquals(expected, actual, "Test case for additing numbers");

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        assertIterableEquals(list1, list2, () -> "This message will be computed when test case will be passed for " + list1 + " and " + list2);
    }

    /**
     * Repeate the test cases
     */
    @RepeatedTest(3)
    void testMultiply() {
        assertEquals(25, mathUtils.multiply(5, 5), "Test case for multiplying the numbers");
    }

    /**
     * Repeate the test cases
     */
    @RepeatedTest(3)
    void testMultiplyAndCaptureRepetition(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        assertEquals(25, mathUtils.multiply(5, 5), "Test case for multiplying the numbers");
    }

    /**
     * Tagging the test cases
     */
    @Test
    @Tag("Maths")
    void testTagging() {
        assertEquals(25, mathUtils.multiply(5, 5), "Test case for multiplying the numbers");
    }

    /**
     * JUnit 5 supports dependency injection  Using TestInfo and TestReporter
     */
    @Test
    @DisplayName("Test Info and Test Reporter")
    @Tag("Maths")
    void testTestinfoAndReporter() {
        testReporter.publishEntry(testInfo.getDisplayName() + " with " + testInfo.getTags() + " tag");
        assertEquals(25, mathUtils.multiply(5, 5), "Test case for multiplying the numbers");
    }

}