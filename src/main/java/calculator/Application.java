package calculator;

import calculator.io.IOHandler;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        Calculator calculator = new Calculator();

        UserInput userInput = ioHandler.getUserInput();
        BigDecimal userInputNumberSummed = calculator.calculate(userInput);
        ioHandler.printResult(userInputNumberSummed);
    }
}
