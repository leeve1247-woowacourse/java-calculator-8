package calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler {
    public UserInput getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawUserInput;
        rawUserInput = getNextLine(scanner);
        UserInput userInput = new UserInput(rawUserInput);
        scanner.close();
        return userInput;
    }

    private String getNextLine(Scanner scanner) {
        String rawUserInput;
        try {
            rawUserInput = scanner.nextLine();
        } catch (NoSuchElementException e){
            rawUserInput = "";
        }
        return rawUserInput;
    }
}
