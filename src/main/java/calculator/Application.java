package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = scanner.nextLine();
        String regex = "[,:]";
        if (userInput.startsWith("//")) {
            int endIndex = userInput.indexOf("\\n");
            String userCustomRegex = userInput.substring("//".length(), endIndex);
            regex = regex + "|" + userCustomRegex;
            userInput = userInput.substring(endIndex + "\\n".length());
        }
        List<BigDecimal> userInputNumbers = null;
        try {
            userInputNumbers = Arrays.stream(userInput.split(regex)).map(BigDecimal::new).toList();
            if (userInputNumbers.stream().anyMatch(number -> number.compareTo(BigDecimal.ZERO) < 0)) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        BigDecimal userInputNumberSummed = userInputNumbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("결과 : " + userInputNumberSummed);
        scanner.close();
    }
}
