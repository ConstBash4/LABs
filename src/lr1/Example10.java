package lr1;

import java.time.LocalDate; //класс для работы с датой и временем
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your year of birth:");
        int birth_year = scanner.nextInt();
        scanner.close();

        int age = checkAge(birth_year);
        if(age != -1) {
            System.out.println("Your age is " + age);
            return;
        }

        System.out.println("Congratulations, you were born in the future!");
    }

    private static int getYear() { //метод получения текущего года
        LocalDate currentDate = LocalDate.now(); //получаем текущую дату в "сыром" виде
        return currentDate.getYear(); //возвращаем только год
    }

    private static int checkAge(int userAge) { //метод проверки возраста
        int currentYear = getYear();
        if(currentYear < userAge) { //если введенный пользователем год больше текущего, то возвращаем -1, иначе возвращаем возраст
            return -1;
        }
        return currentYear - userAge;
    }
}
