import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing of the InfixEvaluation Class
 *
 */

@DisplayName("Testing InfixEvaluation Class")
public class InfixEvaluationTest {

    private InfixEvaluation InfixTest = new InfixEvaluation();

    @Test
    @DisplayName("All operators included in test cases with without spaces")
    void testArithmetic() {
        assertAll(
                () -> {
                    // Test 1: Addition Without Spaces
                    String expressionToEvaluate = "15+3";
                    int expectedEvaluation = 18;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 2: Addition With Spaces
                    String expressionToEvaluate = "15 + 3";
                    int expectedEvaluation = 18;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 3: Subtraction Without Spaces
                    String expressionToEvaluate = "15-3";
                    int expectedEvaluation = 12;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 4: Subtraction With Spaces
                    String expressionToEvaluate = "15 - 3";
                    int expectedEvaluation = 12;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 5: Subtraction With Spaces (Expect Negative)
                    String expressionToEvaluate = "3 - 15";
                    int expectedEvaluation = 12;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 6: Multiplication Without Spaces
                    String expressionToEvaluate = "15 * 3";
                    int expectedEvaluation = 45;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 7: Multiplication With Spaces
                    String expressionToEvaluate = "15 * 3";
                    int expectedEvaluation = 45;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 8: Division Without Spaces
                    String expressionToEvaluate = "15/3";
                    int expectedEvaluation = 5;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 9: Division With Spaces
                    String expressionToEvaluate = "15 / 3";
                    int expectedEvaluation = 5;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                }
        );
    }

    @Test
    @DisplayName("Test cases include cases with parentheses")
    void testParentheses() {
        assertAll(
                () -> {
                    // Test 1: Evaluate with Parentheses
                    String expressionToEvaluate = "(15 / 3) * 2";
                    int expectedEvaluation = 10;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 2: Evaluate with Parentheses
                    String expressionToEvaluate = "(15 / 3) * 2 + 5";
                    int expectedEvaluation = 15;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 3: Evaluate with Parentheses
                    String expressionToEvaluate = "(15 / 3) * 2 + 5 - 8";
                    int expectedEvaluation = 7;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 4: Evaluate with Parentheses
                    String expressionToEvaluate = "(15 / 3) * (2 + (5 - 2))";
                    int expectedEvaluation = 25;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                }
        );
    }

    @Test
    @DisplayName("Test cases include cases to test precedence ")
    void testPrecedence() {
        assertAll(
                () -> {
                    // Test 1: Simple Precedence with Parentheses
                    String expressionToEvaluate = "15 * 3 / 2 + 5 - 2";
                    int expectedEvaluation = 25;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 2: Simple Precedence with Parentheses
                    String expressionToEvaluate = "15 / 5 * 2 + 43 - 8";
                    int expectedEvaluation = 41;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                },
                () -> {
                    // Test 3: Simple Precedence with Parentheses
                    String expressionToEvaluate = "15 / 3 * 2 + 5 - 2";
                    int expectedEvaluation = 13;
                    int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
                    assertEquals(expectedEvaluation, actualEvaluation);
                }
        );
    }

    @Test
    @DisplayName("Test cases include a case to test division by zero ")
    void testDivideByZero() {
        // TODO: Setup Interface so JOptionPane doesn't show.
        assertThrows(DivideByZeroException.class, () -> {
            String expressionToEvaluate = "15 / 0";
            int expectedEvaluation = 0;
            int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
            assertEquals(expectedEvaluation, actualEvaluation);
        });
    }

    @Test
    @DisplayName("Illegal Character")
    void testIllegalChar() {
        // TODO: Setup Interface so JOptionPane doesn't show.
        assertThrows(BadCharacterException.class, () -> {
            String expressionToEvaluate = "15 & 0";
            int expectedEvaluation = 0;
            int actualEvaluation = InfixTest.InfixEvaluation(expressionToEvaluate);
            assertEquals(expectedEvaluation, actualEvaluation);
        });
    }
}