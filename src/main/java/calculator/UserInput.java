package calculator;

import java.util.regex.Pattern;

public class UserInput {
    String rawUserInput;
    String customDelimiter;
    String rawUserInputNumbers;

    public UserInput(String rawUserInput) {
        this.rawUserInput = rawUserInput;
        this.customDelimiter = customDelimiter();
        this.rawUserInputNumbers = rawUserInputNumbers();
    }

    private String customDelimiter() {
        if (isCustomDelimiter()) {
            int endIndex = rawUserInput.indexOf("\\n");
            String substring = rawUserInput.substring("//".length(), endIndex);
            validateChar(substring);
            return Pattern.quote(substring);
        }
        return null;
    }

    private void validateChar(String substring) {
        if (substring.length() > 1) {
            throw new IllegalArgumentException("문자열은 허용되지 않습니다.");
        }
    }

    private String rawUserInputNumbers() {
        String rawUserInputNumbers = rawUserInput;

        if (isCustomDelimiter()) {
            int endIndex = rawUserInput.indexOf("\\n");
            rawUserInputNumbers = rawUserInput.substring(endIndex + 2);
        }

        return rawUserInputNumbers;
    }

    private boolean isCustomDelimiter() {
        return rawUserInput != null && rawUserInput.startsWith("//") && rawUserInput.contains("\\n");
    }
}
