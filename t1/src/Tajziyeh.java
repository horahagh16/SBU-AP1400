import java.util.Scanner;

public class Tajziyeh {
    static int isPrime(long number, int flag) {
        for (int i = 2; i <= Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                flag = 0;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        long number;
        int flag = 1;
        Scanner input = new Scanner(System.in);
        number = input.nextLong();

        for (long i = 2; i < number; i++) {
            long num = 0;
            while (number % i == 0) {
                num++;
                number = number / i;
            }   //tedade tekrare har adade aval

            if (number != 1) {
                if (num != 0) {
                    if (num == 1)
                        System.out.printf("%d*", i);
                    else
                        System.out.printf("%d^%d*", i, num);
                }
            } else {
                System.out.printf("%d^%d", i, num);
            }
            if (isPrime(number, flag) == 1)
                break;
        }
        if (number > 2) {
            System.out.println(number);
        }
    }
}