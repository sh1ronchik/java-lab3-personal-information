import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator(scanner);
        //
        String surname = inputValidator.getValidInput("Enter your surname in Russian: ", "Invalid surname. Please enter only letters.");
        String firstName = inputValidator.getValidInput("Enter your first name in Russian: ", "Invalid first name. Please enter only letters.");
        String patronymic = inputValidator.getValidInput("Enter your middle name in Russian: ", "Invalid middle name. Please enter only letters.");
        String dateOfBirth = inputValidator.getValidDateInput();

        Person person = new Person(surname, firstName, patronymic, dateOfBirth);
        person.calculateAge();
        person.determineGender();

        System.out.println("\nSurname & initials: " + person.getSurname().charAt(0) + person.getSurname().substring(1).toLowerCase() + " " + firstName.charAt(0) + "." + patronymic.charAt(0) + ".");
        System.out.println("Gender: " + person.getGender());
        System.out.println("Age: " + person.getAge());
    }
}