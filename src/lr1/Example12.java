package lr1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your age:");
        int age = scanner.nextInt();
        scanner.close();

        int birth_year = checkAge(age);
        if(birth_year != -1) {
            System.out.println("Your year of birth is " + birth_year);
            return;
        }
        System.out.println("Wrong age: " + age);
    }

    private static int getYear() { //метод получения текущего года
        LocalDate currentDate = LocalDate.now(); //получаем текущую дату в "сыром" виде
        return currentDate.getYear(); //возвращаем только год
    }

    private static int checkAge(int userAge) { //метод проверки возраста
        int currentYear = getYear();
        if(0 > userAge) { //если введенный пользователем возраст меньше 0, то возвращаем -1, иначе возвращаем год рождения
            return -1;
        }
        return currentYear - userAge;
    }
}
