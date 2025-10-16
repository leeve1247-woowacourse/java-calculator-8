package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserInput {
    private final String customDelimiter;
    private final String rawUserInputNumbers;

    public UserInput(String rawUserInput) {
        this.customDelimiter = customDelimiter(rawUserInput);
        this.rawUserInputNumbers = rawUserInputNumbers(rawUserInput);
    }

    public List<String> getUserInputNumbers(String regex) {
        return Arrays.stream(rawUserInputNumbers.split(regex)).toList();
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    private String customDelimiter(String rawUserInput) {
        if (isCustomDelimiter(rawUserInput)) {
            return extractCustomDelimiter(rawUserInput);
        }
        return null;
    }

    private String extractCustomDelimiter(String rawUserInput) {
        int endIndex = rawUserInput.indexOf("\\n");
        String substring = rawUserInput.substring("//".length(), endIndex);
        validateChar(substring);
        return Pattern.quote(substring);
    }

    private void validateChar(String substring) {
        if (substring.length() > 1) {
            throw new IllegalArgumentException("문자열은 허용되지 않습니다.");
        }
    }

    private String rawUserInputNumbers(String rawUserInput) {
        String rawUserInputNumbers = rawUserInput;

        if (isCustomDelimiter(rawUserInput)) {
            int endIndex = rawUserInput.indexOf("\\n");
            rawUserInputNumbers = rawUserInput.substring(endIndex + 2);
        }

        return rawUserInputNumbers;
    }

    private boolean isCustomDelimiter(String rawUserInput) {
        return rawUserInput != null && rawUserInput.startsWith("//") && rawUserInput.contains("\\n");
    }
}
