import java.util.Scanner;

public class vezaratkhoone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] hour = new int[100];
        for (int i = 0; i < n; i++) {
            int come = input.nextInt();
            int left = input.nextInt();
            for (int j = come; j < left; j++) {
                hour[j]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (hour[i] > max)
                max = hour[i];
        }
        System.out.println(max);
    }
}