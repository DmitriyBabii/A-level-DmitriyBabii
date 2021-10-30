package HW2;

import java.util.Random;

class Main {
    public static void main(String[] args) {

        //TASK 1
        System.out.println("TASK 1");
        final double a = 5, b = 7, c = 4;
        System.out.printf("a = %.2f\n" +
                        "b = %.2f\n" +
                        "c = %.2f\n" +
                        "S = %.4f\n",
                a, b, c, areaTriangle(a, b, c));

        //TASK 2
        System.out.println("\nTASK 2");
        int[] mass = createRandom(3);

        System.out.print("Numbers: ");
        for (int j : mass) {
            System.out.print(j + " ");
        }
        System.out.println("\nMin: " + foundMin(mass));

        //TASK 3
        System.out.println("\nTASK 3");
        Random rand = new Random();
        int value = rand.nextInt();
        System.out.println(value + (isEven(value) ? " is an even number" : " is not an even number"));

        //TASK 4
        System.out.println("\nTASK 4");
        value = rand.nextInt();
        System.out.printf("%d is %s\n", value, toBinary(value));

    }

    //TASK 1
    private static double areaTriangle(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    //TASK 2
    private static int[] createRandom(int n) {
        final int FROM = -15, TO = 15;

        Random rand = new Random();
        int[] mass = new int[n];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = FROM + rand.nextInt(TO * 2 + 1);
        }
        return mass;
    }

    private static int foundMin(int[] mass) {
        int min = mass[0];

        for (int i = 1; i < mass.length; i++) {
            min = Math.min(Math.abs(min), Math.abs(mass[i]));
        }

        return min;
    }

    //TASK 3
    private static boolean isEven(int value) {
        return (value & 1) == 0;
    }

    //TASK 4
    private static String toBinary(int value) {
        String str = "";
        value = Math.abs(value);
        if (value == 0)
            return "0";

        while (value != 0) {
            str = (value % 2) + str;
            value >>= 1;        //value /= 2;
        }
        return str;
    }
}
