package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public BigDecimal calculate(UserInput userInput) {
        String regex = "[,:]";
        regex = regex + "|" + userInput.customDelimiter;
        List<BigDecimal> numbers;

        try {
            numbers = Arrays.stream(userInput.rawUserInputNumbers.split(regex))
                    .map(BigDecimal::new)
                    .toList();
            validateNegative(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void validateNegative(List<BigDecimal> numbers) {
        if (numbers.stream().anyMatch(n -> n.compareTo(BigDecimal.ZERO) < 0)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}