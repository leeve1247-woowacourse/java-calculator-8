package calculator;

import java.util.Scanner;

public class InputHandler {
    public UserInput getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawUserInput = scanner.nextLine();
        UserInput userInput = new UserInput(rawUserInput);
        scanner.close();
        return userInput;
    }
}
