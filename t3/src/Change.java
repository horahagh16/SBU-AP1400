import java.util.Scanner;

public class Change {

    public static int counter(int[] first, int[] second, int n, int k) {
        int counter;
        int[] countArr = new int[2 * k - 2];
        for (int sum = 2, t = 0; sum < 2 * k; sum++, t++) {
            counter = 0;
            for (int i = 0; i < n / 2; i++) {
                if (first[i] + second[i] != sum) {
                    if (first[i] <= k && sum - first[i] <= k && sum - first[i] > 0)
                        counter++;
                    else if (second[i] <= k && sum - second[i] <= k && sum - second[i] > 0)
                        counter++;
                    else
                        counter += 2;
                }
            }
            countArr[t] = counter;
        }
        return minCount(countArr);
    }

    public static int minCount(int[] counter) {
        //counter[0] = 1000;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < counter[0]) {
                counter[0] = counter[i];
            }
        }
        return counter[0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int counter;
        if (n % 2 == 0) {
            int[] first = new int[n / 2];
            int[] second = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                first[i] = input.nextInt();
            }
            for (int i = n / 2 - 1; i >= 0; i--) {
                second[i] = input.nextInt();
            }
            int k = input.nextInt();
            counter = counter(first, second, n, k);
        } else {
            int[] first = new int[n / 2 + 1];
            int[] second = new int[n / 2];
            for (int i = 0; i < n / 2 + 1; i++) {
                first[i] = input.nextInt();
            }
            for (int i = n / 2 - 1; i >= 0; i--) {
                second[i] = input.nextInt();
            }
            int k = input.nextInt();
            counter = counter(first, second, n, k);
        }
        System.out.println(counter);
    }
}