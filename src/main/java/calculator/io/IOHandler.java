package calculator.io;

import calculator.UserInput;
import java.math.BigDecimal;

public class IOHandler {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public IOHandler() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public UserInput getUserInput() {
        return inputHandler.readUserInput();
    }

    public void printResult(BigDecimal userInputNumberSummed) {
        outputHandler.printResult(userInputNumberSummed);
    }
}
