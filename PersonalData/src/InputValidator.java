import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValidInput(String prompt, String errorMessage) {
        String input;
        boolean isValid;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            isValid = input.matches("[А-Яа-я]+");
            if (!isValid) {
                System.out.println(errorMessage);
            }
        } while (!isValid);
        return input;
    }

    public String getValidDateInput() {
        String input;
        boolean isValid;
        do {
            System.out.println("Enter your date of birth (in the format DD.MM.YYYY): ");
            input = scanner.nextLine();
            isValid = Pattern.matches("\\d{2}\\.\\d{2}\\.\\d{4}", input);
            if (!isValid) {
                System.out.println("Invalid date of birth. Please enter in the format DD.MM.YYYY.");
            }
        } while (!isValid);
        return input;
    }
}