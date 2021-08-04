import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Chinesh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] mainNum = new int[n];
        for (int i = 0; i < n; i++) {
            mainNum[i] = input.nextInt();
        }
        Arrays.sort(mainNum);
        int[] smals = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            smals[i] = mainNum[i];
        }
        if (n % 2 == 0) {//tedade zoj
            int[] bigs = new int[n / 2];
            for (int i = n / 2, j = 0; i < n; i++, j++) {
                bigs[j] = mainNum[i];
            }
            for (int i = 0, j = n / 2 - 1; i < n / 2; i++, j--) {
                System.out.printf("%d %d ", bigs[j], smals[i]);
            }
        } else {
            int[] bigs = new int[n / 2 + 1];
            for (int i = n / 2, j = 0; i < n; i++, j++) {
                bigs[j] = mainNum[i];
            }
            for (int i = 0, j = n / 2; i < n / 2; i++, j--) {
                System.out.printf("%d %d ", bigs[j], smals[i]);
            }
            System.out.printf("%d", bigs[0]);
        }
    }
}