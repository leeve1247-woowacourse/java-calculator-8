package calculator.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.UserInput;
import java.util.NoSuchElementException;

public class InputHandler {
    public UserInput readUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawUserInput;
        rawUserInput = readNextLine();
        return new UserInput(rawUserInput);
    }

    private String readNextLine() {
        String rawUserInput;
        try {
            rawUserInput = readLine();
        } catch (NoSuchElementException e) {
            rawUserInput = "";
        }
        return rawUserInput;
    }
}
