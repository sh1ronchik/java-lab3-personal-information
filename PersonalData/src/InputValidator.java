import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu").withResolverStyle(ResolverStyle.STRICT);
        do {
            System.out.println("Enter your date of birth (in the format DD.MM.YYYY): ");
            input = scanner.nextLine();
            try {
                LocalDate.parse(input, formatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date of birth. Please enter in the format DD.MM.YYYY.");
                isValid = false;
            }
        } while (!isValid);
        return input;
    }
}
