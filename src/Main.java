import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задача");
        System.out.println("Какой сейчас год?");
        Scanner tyk = new Scanner(System.in);
        int year = tyk.nextInt();
        String yearNow = checkLeapYear(year);

        System.out.println("");
        System.out.println("");
        System.out.println("2 задача");
        System.out.println("Если у вас android введите 1, если apple, введите 0");
        Scanner osIn = new Scanner(System.in);
        int os2 = osIn.nextInt();
        System.out.println("Уточните, пожалуйста, год выпуска вашего мобильного устройства.");
        Scanner y = new Scanner(System.in);
        int yearOs2 = y.nextInt();
        String message = selectMessage(yearOs2, os2);
        System.out.println(message);

        System.out.println("");
        System.out.println("");
        System.out.println("3 задача");
        System.out.println("Пожалуйста, укажите дистанцию от вашего дома до отделения банка.");
        Scanner km = new Scanner(System.in);
        int deliveryDistance = km.nextInt();
        String answ = calculateDeliveryTime(deliveryDistance);
        System.out.println(answ);
    }

    //метод первой задачи
    public static String checkLeapYear(int year) {
        int a = 100;
        int b = 400;
        int c = 4;
        String nowYear = year + " - год не является високосным";
        if (year < 1584) {
            nowYear = "Вы ввели год до 1584";
        } else if (year % b != 0 && year % a == 0 && year > 1584) {
            nowYear = year + " - год не является високосным.";
        } else if (year % b == 0 || year % c == 0 && year > 1584) {
            nowYear = year + " - год является високосным.";
        }
        System.out.printf(nowYear);
        return nowYear;
    }

    //Метод второй задачи
    public static String selectMessage(int yearOs, int os) {
        int currentYear = LocalDate.now().getYear();
        String messageForUser = "Установите ";
        if (yearOs < currentYear) {
            messageForUser = messageForUser + "облегченную версию ";
        } else if (yearOs == currentYear) {
            messageForUser = messageForUser + "версию ";
        }
        if (os == 0) {
            messageForUser = messageForUser + "для iOS по ссылке.";
        } else if (os == 1) {
            messageForUser = messageForUser + "для android по ссылке.";
        } else if (os > 1) {
            throw new RuntimeException("Вы ввели неверные данные ОС.");
        } else if (yearOs < 1990 || yearOs > currentYear) {
            throw new RuntimeException("Вы ввели неверный год.");
        }
        return messageForUser;
    }

    //Метод третьей задачи
    public static String calculateDeliveryTime(int distance) {
        String answer = "";
        if (distance <= 20) {
            answer = "Доставка займет 1 день.";
        } else if (distance > 20 && distance <= 60) {
            answer = "Доставка займет 2 дня.";
        } else if (distance > 60 && distance <= 100) {
            answer = "Доставка займет 3 дня.";
        } else if (distance > 100) {
            answer = "Извините, мы не осуществляем доставку карт свыше 100 километров.";
        } else if (distance < 0) {
            throw new RuntimeException("Вы ввели неверные данные");
        }
        return answer;
    }
}

