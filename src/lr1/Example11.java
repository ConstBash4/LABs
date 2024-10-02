package lr1;

import java.time.LocalDate; //класс для работы с датой и временем
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your name:");
        String name = scanner.nextLine();

        System.out.println("Input your year of birth:");
        int birth_year = scanner.nextInt();
        scanner.close();

        System.out.print("Your name is " + name + " ");
        int age = checkAge(birth_year);
        if(age != -1) {

            System.out.print("and your age is " + age);
            return;
        }

        System.out.print("and you were born in the future!");
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
