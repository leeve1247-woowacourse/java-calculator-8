package calculator.io;

import java.math.BigDecimal;

public class OutputHandler {
    public void printResult(BigDecimal result) {
        System.out.println("결과 : " + result.toString());
    }
}
