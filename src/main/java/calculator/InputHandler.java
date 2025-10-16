package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.NoSuchElementException;

public class InputHandler {
    public UserInput getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawUserInput;
        rawUserInput = getNextLine();
        return new UserInput(rawUserInput);
    }

    private String getNextLine() {
        String rawUserInput;
        try {
            rawUserInput = readLine();
        } catch (NoSuchElementException e){
            rawUserInput = "";
        }
        return rawUserInput;
    }
}
