import java.util.Arrays;
import java.util.Scanner;

public class Badihy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        int start, flag = 0;
        int[] sumArr = new int[(n * (n + 1)) / 2];//mesle pare khatha
        int k = 0;
        for (int i = 0; i < n; i++) {
            start = 0;
            for (int j = i; j < n; j++) {
                start = start + num[j];
                sumArr[k] = start;
                k++;
            }
        }
        Arrays.sort(sumArr);
        for (int i = 1; i < sumArr.length; i++) {
            if (sumArr[i] == sumArr[i - 1])
                flag = 1;
        }
        if (flag == 1) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}