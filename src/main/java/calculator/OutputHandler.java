package calculator;

import java.math.BigDecimal;

public class OutputHandler {
    public void printResult(String result) {
        System.out.println("결과 : " + result);
    }
    public void printResult(BigDecimal result) {
        System.out.println("결과 : " + result.toString());
    }
}
