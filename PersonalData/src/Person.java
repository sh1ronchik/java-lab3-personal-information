import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private final String surname;
    private final String firstName;
    private final String patronymic;
    private final String dateOfBirth;
    private int age;
    private String gender;

    public Person(String surname, String firstName, String patronymic, String dateOfBirth) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public void calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        this.age = Period.between(birthDate, currentDate).getYears();
    }

    public void determineGender() {
        char firstLetter = surname.charAt(0);
        if (firstLetter == 'А' || firstLetter == 'Я') {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
    }

    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public String getDateOfBirth() { return dateOfBirth; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
}