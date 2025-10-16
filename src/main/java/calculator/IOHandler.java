package calculator;

import java.math.BigDecimal;

public class IOHandler {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public IOHandler() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }


    public UserInput getUserInput() {
        return inputHandler.getUserInput();
    }

    public void printResult(BigDecimal userInputNumberSummed) {
        outputHandler.printResult(userInputNumberSummed);
    }
}
