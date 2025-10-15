package calculator;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        StringCalculator stringCalculator = new StringCalculator();

        UserInput userInput = inputHandler.getUserInput();
        BigDecimal userInputNumberSummed = stringCalculator.calculate(userInput);
        outputHandler.printResult(userInputNumberSummed);
    }
}
