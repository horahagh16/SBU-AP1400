import java.util.Scanner;

public class Kachi {
    public static long findMod(long num) {
        long m = 1000000007;
        return (num % m + m) % m;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        if (k > n) {
            long[] num = new long[k];
            for (int i = 0; i < k; i++) {
                num[i] = input.nextLong();
            }
            System.out.println(num[n - 1]);
        } else {
            long[] num = new long[n];
            for (int i = 0; i < k; i++) {
                num[i] = input.nextLong();
            }
            for (int i = k; i < n; i++) {
                if (i == n - 1) {

                }
                for (int j = 1; j <= k; j++) {
                    num[i] = num[i] + num[i - j];
                    num[i] = findMod(num[i]);
                }
            }
            System.out.println(num[n - 1]);
        }
    }
}