package calculator;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Calculator calculator = new Calculator();

        UserInput userInput = inputHandler.getUserInput();
        BigDecimal userInputNumberSummed = calculator.calculate(userInput);
        outputHandler.printResult(userInputNumberSummed);
    }
}
