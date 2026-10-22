package lv.bootcamp.shelter.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Task 1: Pure logic tests
 *
 * Practice:
 * - Arrange-Act-Assert pattern
 * - Good test naming
 * - assertEquals for return values
 * - assertThrows for invalid input
 *
 * Instructions:
 * Write tests for AgeCalculator. Each TODO describes one test to write.
 * Remove the TODO comments as you implement each test.
 */
@DisplayName("AgeCalculator")
class AgeCalculatorTest {

    private AgeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new AgeCalculator();
    }

    // --- toMonths() ---

    @Test
    @DisplayName("toMonths: 0 years returns 0 months")
    void shouldReturnZeroMonthsForZeroYears() {
        int months = this.calculator.toMonths(0);
        assertEquals(0, months);
    }

    @Test
    @DisplayName("toMonths: positive years returns correct months")
    void shouldConvertPositiveYearsToMonths() {
        int months = this.calculator.toMonths(3);
        assertEquals(36, months);
    }

    @Test
    @DisplayName("toMonths: negative years throws IllegalArgumentException")
    void shouldThrowForNegativeYears() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            this.calculator.toMonths(-1)
        );

        assertTrue(exception.getMessage().contains("negative"));
    }

    // --- dogToHumanYears() ---

    @Test
    @DisplayName("dogToHumanYears: age 0 returns 0")
    void shouldReturnZeroHumanYearsForPuppy() {
        int years = this.calculator.dogToHumanYears(0);
        assertEquals(0, years);
    }

    @Test
    @DisplayName("dogToHumanYears: age 1 returns 15")
    void shouldReturnFifteenForOneYearOldDog() {
        int years = this.calculator.dogToHumanYears(1);
        assertEquals(15, years);
    }

    @Test
    @DisplayName("dogToHumanYears: age 2 returns 24")
    void shouldReturnTwentyFourForTwoYearOldDog() {
        int years = this.calculator.dogToHumanYears(2);
        assertEquals(24, years);
    }

    @Test
    @DisplayName("dogToHumanYears: age 5 returns 39")
    void shouldCalculateCorrectlyForOlderDog() {
        int years = this.calculator.dogToHumanYears(5);
        assertEquals(39, years);
    }

    @Test
    @DisplayName("dogToHumanYears: negative age throws IllegalArgumentException")
    void shouldThrowForNegativeDogAge() {
        assertThrows(IllegalArgumentException.class, () -> this.calculator.dogToHumanYears(-1));
    }

    // --- isBaby() ---

    @Test
    @DisplayName("isBaby: age 0 returns true")
    void shouldReturnTrueForAgZero() {
        assertTrue(this.calculator.isBaby(0));
    }

    @Test
    @DisplayName("isBaby: age 1 returns false")
    void shouldReturnFalseForAgeOne() {
        assertFalse(this.calculator.isBaby(1));
    }
}
