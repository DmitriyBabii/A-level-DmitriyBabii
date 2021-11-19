package com.alevel.cw3;

import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        task0();
        task1();
        task2();
        task3();
        task4();
        task5();

    }

    /**
     * Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
     */
    private static void task0() {
        System.out.println("\nNUMBER OF WORDS");
        System.out.print("Enter your sentence: ");
        String str = new Scanner(System.in).nextLine();
        String[] mass = str.trim().split(" ");
        int count = 0;
        for (String s : mass) {
            if (s.trim().isEmpty()) {
                continue;
            }
            count++;
        }
        System.out.println("There are " + count + " words in the sentence.");
    }

    /**
     * Для введённого пользователем с клавиатуры натурального
     * числа посчитайте сумму всех его цифр (заранее не известно сколько цифр будет в числе).
     */
    private static void task1() {
        System.out.println("\nSUM OF DIGITS NUMBERS");
        Scanner in = new Scanner(System.in);
        boolean flag = false;

        do {
            try {
                flag = false;
                System.out.print("Enter your number: ");
                int number = Integer.parseInt(in.next());
                System.out.println("Sum = " + numberSum(number));

            } catch (Exception ex) {
                System.out.println("You didn't enter numbers" +
                        "\nTry again");
                flag = true;
            }
        } while (flag);
    }

    public static int numberSum(int number) throws Exception {
        if (number < 0) {
            throw new Exception();
        }

        final int divider = 10;
        int sum = 0;

        while (number > 0) {
            sum += number % divider;
            number /= divider;
        }
        return sum;
    }

    /**
     * Счастливые билеты
     * В городе N проезд в трамвае осуществляется по бумажным отрывным билетам.
     * Каждую неделю трамвайное депо заказывает в местной типографии рулон билетов
     * с номерами от 000001 до 999999. «Счастливым» считается билетик у которого сумма
     * первых трёх цифр номера равна сумме последних трёх цифр, как, например, в билетах
     * с номерами 003102 или 567576. Трамвайное депо решило подарить сувенир обладателю
     * каждого счастливого билета и теперь раздумывает, как много сувениров потребуется.
     * С помощью программы подсчитайте сколько счастливых билетов в одном рулоне?
     */
    private static void task2() {
        System.out.println("\nLUCKY TICKETS");
        final int divider = 10;
        int count = 0;

        for (int i = 1001; i <= 999999; i++) {
            int value = i;
            int sumFirst = 0, sumSecond = 0;

            for (int j = 0; j < 3 && value > 0; j++) {
                sumFirst += value % divider;
                value /= divider;
            }

            for (int j = 0; j < 3 && value > 0; j++) {
                sumSecond += value % divider;
                value /= divider;
            }

            if (sumFirst == sumSecond) {
                count++;
            }
        }

        System.out.println("There are " + count + " lucky tickets.");
    }

    /**
     * Симметрия времени
     * Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько раз
     * за сутки случается так, что слева от двоеточия указывается симметричная комбинация для той,
     * что справа от двоеточия (например, 02:20, 11:11 или 15:51).
     */
    private static void task3() {
        System.out.println("\nTIME SYMMETRY");
        int count = 0;

        for (int h = 0; h < 24; h++) {
            String hour = String.valueOf(h);
            if (h < 10) {
                hour = "0" + hour;
            }

            for (int m = 0; m < 24; m++) {
                String minute = String.valueOf(m);
                if (m < 10) {
                    minute = "0" + minute;
                }
                if (hour.equals(minute) &&
                        Integer.parseInt(minute = new StringBuilder(minute).reverse().toString()) < 60) {
                    System.out.println(hour + ":" + minute);
                    count++;
                }

            }
        }
        System.out.println(count + " times.");
    }

    /**
     * Программа "Угадай число"
     * <p>
     * !!!Правила изменены!!!
     * Правила игры:
     * Вам необходимо отгадать загаданное число от 0 до 9999.
     * После ввода вашего варианты будут написаны подсказки под каждой введенной цыфрой.
     * + цыфра отгадана
     * ~ цыфра стоит не на своем месте
     * - такой цыфры нет
     * Цыфры могут повторяться.
     */
    private static void task4() {
        System.out.println("\nGAME");
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int count = 0;
        int secret = rand.nextInt(10000);

        System.out.println("Rules of the game:\n" +
                "You need to guess the hidden number from 0 to 9999.\n" +
                "After entering your options, hints will be written under each entered number.\n" +
                "+ number guessed\n" +
                "~ the number is out of place\n" +
                "- there is no such number\n" +
                "The numbers can be repeated.");

        System.out.print("Enter your answer");

        do {
            try {
                System.out.print("\n--->");
                int guess = Integer.parseInt(in.next());
                System.out.print("\t");
                int divider = 10000;
                count = 0;

                for (int i = 0; i < 4; i++) {

                    if (takeOneOf(guess, divider) == takeOneOf(secret, divider)) {
                        System.out.print("+");
                        count++;
                    } else if (isThere(secret, takeOneOf(guess, divider))) {
                        System.out.print("~");
                    } else {
                        System.out.print("-");
                    }

                    divider /= 10;
                }

            } catch (Exception ex) {
                System.out.println("You entered incorrect data");
            }
        } while (count != 4);

        System.out.println("\nYOU WIN!!!");
    }

    private static boolean isThere(int secret, int key) {
        while (secret > 0) {
            if (secret % 10 == key) {
                return true;
            }
            secret /= 10;
        }
        return false;
    }

    private static int takeOneOf(int value, int divider) {
        return (value % divider) / (divider / 10);
    }


    /**
     * Простейший калькулятор
     * <p>
     * !!!Калькулятор был сделан другой!!!
     * Правила:
     * Вводить все данные через пробел (числа и операторы)
     * При неправильном вводе данных программа об этом скажет (включая деление на ноль)
     * Калькулятор не имеет приоритетности выполнения операторов, а так же не использует скобки
     * Вводить можно только целочисленные значения и операторы +, -, *, /
     * Чтобы выйти необходимо написать "0"
     * <p>
     * Пример правильного заполнения:
     * 5 - 1 + 2 * 3 / 4
     * Результат: 4.5
     */
    private static void task5() {
        System.out.println("\nCALCULATOR");
        Scanner in = new Scanner(System.in);
        String expression;

        do {
            System.out.print("Enter your expression: ");
            expression = in.nextLine();
            if (expression.equals("0")) {
                break;
            }
            try {
                System.out.printf("Result = %.4f\n", calculate(expression));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

    }

    public static double calculate(String expression) throws Exception {
        expression = expression.trim();
        String[] mass = expression.split(" ");

        if (isCorrect(mass)) {
            if (mass.length == 1) {
                return Integer.parseInt(mass[0]);
            }
            return switchForMany(mass);
        }
        return 0;
    }

    private static boolean isCorrect(String[] mass) throws Exception {
        if ((((mass.length & 1) == 0) && (mass.length != 0))) {
            throw new Exception("Insufficient data.");
            //System.out.println("Insufficient data.");
            //return false;
        }

        for (int i = 0; i < mass.length; i++) {
            //try {
            if ((i & 1) == 0) {
                Integer.parseInt(mass[i]);
            } else if (!mass[i].equals("/") && !mass[i].equals("*") &&
                    !mass[i].equals("-") && !mass[i].equals("+")) {
                throw new Exception("The calculator has only 4 definitions (+, -, *, /).");
                //System.out.println("The calculator has only 4 definitions (+, -, *, /).");
                //return false;
            } else if (mass[i].equals("/") && mass[i + 1].equals("0")) {
                throw new Exception("You cannot divide by zero");
                //System.out.println("You cannot divide by zero");
                //return false;
            }

            //} catch (Exception ex) {
            //System.out.println("The calculator only accepts int values.");
            //return false;
            //}
        }

        return true;
    }

    private static double switchForOne(String[] mass) {
        double result = 0;

        switch (mass[1]) {
            case "+": {
                result = Integer.parseInt(mass[0]) + Integer.parseInt(mass[2]);
                break;
            }
            case "-": {
                result = Integer.parseInt(mass[0]) - Integer.parseInt(mass[2]);
                break;
            }
            case "*": {
                result = Integer.parseInt(mass[0]) * Integer.parseInt(mass[2]);
                break;
            }
            case "/": {
                result = (double) Integer.parseInt(mass[0]) / Integer.parseInt(mass[2]);
                break;
            }

        }

        return result;
    }

    private static double switchForMany(String[] mass) {
        double result = switchForOne(mass);

        for (int i = 3; i < mass.length; i += 2) {
            switch (mass[i]) {
                case "+": {
                    result += Integer.parseInt(mass[i + 1]);
                    break;
                }
                case "-": {
                    result -= Integer.parseInt(mass[i + 1]);
                    break;
                }
                case "*": {
                    result *= Integer.parseInt(mass[i + 1]);
                    break;
                }
                case "/": {
                    result /= 1.0 * Integer.parseInt(mass[i + 1]);
                    break;
                }
            }
        }

        return result;
    }

}