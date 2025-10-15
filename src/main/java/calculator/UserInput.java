package calculator;

public class UserInput {
    String rawUserInput;
    String customDelimiter;
    String rawUserInputNumbers;

    public UserInput(String rawUserInput) {
        this.rawUserInput = rawUserInput;
        this.customDelimiter = customDelimiter();
        this.rawUserInputNumbers = rawUserInputNumbers();
    }

    private boolean isCustomDelimiter() {
        return rawUserInput != null && rawUserInput.startsWith("//") && rawUserInput.contains("\\n");
    }

    private String customDelimiter() {
        if (isCustomDelimiter()) {
            int endIndex = rawUserInput.indexOf("\\n");
            return rawUserInput.substring("//".length(), endIndex);
        }
        return null;
    }

    private String rawUserInputNumbers() {
        if (isCustomDelimiter()) {
            int endIndex = rawUserInput.indexOf("\\n");
            String rawUserInputNumbers = rawUserInput.substring(endIndex + 2);
            validateUserInputNumbersEmptiness(rawUserInputNumbers);
            return rawUserInputNumbers;
        }
        return rawUserInput;
    }

    private static void validateUserInputNumbersEmptiness(String rawUserInputNumbers) {
        if (rawUserInputNumbers.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
