import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("tests started");
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при передаче отрицательного либо нулевого значения")
    void testGivenNullOrMinusSideWhenTriangleSquareThenException() {
        assertAll(
                () -> assertThatExceptionOfType(IncorrectSideLengthException.class).isThrownBy(() -> Triangle.triangleSquare(0, 1, 1)),
                () -> assertThatExceptionOfType(IncorrectSideLengthException.class).isThrownBy(() -> Triangle.triangleSquare(-1, 1, 1)),
                () -> assertThatExceptionOfType(IncorrectSideLengthException.class).isThrownBy(() -> Triangle.triangleSquare(-1, -1, 1)),
                () -> assertThatExceptionOfType(IncorrectSideLengthException.class).isThrownBy(() -> Triangle.triangleSquare(0, -1, 0))
        );
    }

    @Test
    @DisplayName("Проверка метода triangleSquare с целыми числами и целым результатом")
    void testGivenIntegersSidesWhenTriangleSquareThenCorrectResult() throws IncorrectSideLengthException {
        assertEquals(Triangle.triangleSquare(6, 8, 10), 24);
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при получении дробного значения площади")
    void testGivenSidesWhenTriangleSquareThenDoubleResult() throws IncorrectSideLengthException {
        assertEquals(Triangle.triangleSquare(6, 5, 2.2), (double) 5.28);
    }

    @Test
    @DisplayName("Проверка метода triangleSquare при передаче сторон не образующих треугольник")
    void testGivenIncorrectSidesWhenTriangleSquareThenException() {
        assertThatExceptionOfType(IncorrectSideLengthException.class).isThrownBy(() -> Triangle.triangleSquare(1, 2, 1));
    }

    @AfterAll
    static void afterAll() {
        logger.info("tests completed");
    }
}