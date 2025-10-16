package calculator;

import java.math.BigDecimal;
import java.util.List;


public class Calculator {
    private static final BigDecimal ZERO = BigDecimal.ZERO;

    private static String stringZeroIfEmpty(String rawInput) {
        if (rawInput.isEmpty()) {
            return "0";
        }
        return rawInput;
    }

    public BigDecimal calculate(UserInput userInput) {
        String regex = "[,:]";
        regex = regex + "|" + userInput.getCustomDelimiter();
        List<BigDecimal> numbers = userInput.getUserInputNumbers(regex)
                .stream()
                .map(Calculator::stringZeroIfEmpty)
                .map(BigDecimal::new)
                .toList();
        validateNegative(numbers);

        return numbers
                .stream()
                .reduce(ZERO, BigDecimal::add);
    }

    private void validateNegative(List<BigDecimal> numbers) {
        if (numbers
                .stream()
                .anyMatch(this::isNegative)
        ) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isNegative(BigDecimal number) {
        return number.compareTo(ZERO) < 0;
    }
}