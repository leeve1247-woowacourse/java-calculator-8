package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public BigDecimal calculate(UserInput userInput) {
        String regex = "[,:]";
        regex = regex + "|" + userInput.customDelimiter;
        List<BigDecimal> numbers = Arrays.stream(userInput.rawUserInputNumbers.split(regex))
                .map(Calculator::blankToStringZero)
                .map(BigDecimal::new)
                .toList();
        validateNegative(numbers);

        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static String blankToStringZero(String rawInput) {
        if (rawInput.isBlank())
            return "0";
        return rawInput;
    }

    private void validateNegative(List<BigDecimal> numbers) {
        if (numbers.stream().anyMatch(n -> n.compareTo(BigDecimal.ZERO) < 0)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}