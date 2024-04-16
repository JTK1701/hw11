import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задача");
        System.out.println("Введите любой год после 1584");
        Scanner tyk = new Scanner(System.in);
        int year = tyk.nextInt();
        String yearNow = checkLeapYear(year);
        System.out.println(yearNow);
        //2
        System.out.println("");
        System.out.println("");
        System.out.println("2 задача");
        System.out.println("Если у вас android введите 1, если apple, введите 0");
        Scanner osIn = new Scanner(System.in);
        int os2 = osIn.nextInt();
        if (os2 > 1) {
            throw new RuntimeException("Вы ввели неверные данные ОС.");
        }
        System.out.println("Уточните, пожалуйста, год выпуска вашего мобильного устройства.");
        Scanner y = new Scanner(System.in);
        int yearOs2 = y.nextInt();
        if (yearOs2 < 1990 || yearOs2 > 2024) {
            throw new RuntimeException("Вы ввели неверный год.");
        }
        String message = selectMessage(yearOs2, os2);
        System.out.println(message);
        //3
        System.out.println("");
        System.out.println("");
        System.out.println("3 задача");
        System.out.println("Пожалуйста, укажите дистанцию от вашего дома до отделения банка.");
        Scanner km = new Scanner(System.in);
        int deliveryDistance = km.nextInt();
        String mess = "";
        if (deliveryDistance < 0) {
            throw new RuntimeException("Вы ввели неверные данные");
        }
        int answ = calculateDeliveryTime(deliveryDistance);
        if (answ < 4) {
            mess = "Доставка займет дней - " + answ;
        } else if (answ == 4) {
            mess = "Извините, доставка в зону свыше 100 км не осуществляется.";
        }
        System.out.println(mess);
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
        }
        return messageForUser;
    }

    //Метод третьей задачи
    public static int calculateDeliveryTime(int distance) {
        int answer = 0;
        if (distance <= 20) {
            answer = 1;
        } else if (distance > 20 && distance <= 60) {
            answer = 2;
        } else if (distance > 60 && distance <= 100) {
            answer = 3;
        } else if (distance > 100) {
            answer = 4;
        }
        return answer;
    }
    //Герман, привет еще раз. А тут у меня, почему-то именно Ctrl+Alt+L делает отступы между строками в методах. Так и должно быть?
}

