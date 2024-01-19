package calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class SeriesCalculator {
    /**
     * Calculates the sum of the series (1 / n!) * (1! + 2! + 3! + ... + n!)
     *
     * @param n The number of terms in the series. Must be greater than or equal to 2.
     * @param precision The precision for the division operation. Must be greater than 1.
     * @return The sum of the series up to the nth term.
     * @throws IllegalArgumentException if n is less than 2 or precision is less than or equal to 1.
     */
    public double calculateSeries(int n, int precision) {
        if (n < 2 || precision <= 1) {
            throw new IllegalArgumentException("n must be greater than or equal to 0, and precision must be greater than 1.");
        }

        BigDecimal factorialSum = BigDecimal.ZERO;
        BigDecimal factorial = BigDecimal.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
            factorialSum = factorialSum.add(factorial);
        }

        BigDecimal result = factorialSum.divide(factorial, new MathContext(precision));
        return result.doubleValue();
    }
}
