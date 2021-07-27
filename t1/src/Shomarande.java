import java.util.Scanner;

public class Shomarande {
    static int feelNumber(int n) {
        //2^(p-1)*(2^p-1)
        if (n != 1) {
            int sum = 1;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i != n)
                        sum = sum + i + n / i;
                    else
                        sum = sum + i;
                }
            }
            if (sum == n)//kamel
                return 2;
            else if (sum > n)//kesrat
                return 3;
            else //kambood
                return 1;
        } else
            return 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        int kambood = 0, kamel = 0, kesrat = 0;
        for (int x = start; x <= end; x++) {
            if (feelNumber(x) == 1) {
                kambood++;
            } else if (feelNumber(x) == 2)
                kamel++;
            else
                kesrat++;
        }
        System.out.printf("%d %d %d\n", kambood, kamel, kesrat);
    }
}