import java.util.Scanner;

public class davinci {
    static int[] numerator(int s) {
        int[] numerators = new int[(int) (Math.sqrt(s) + 1)];
        int j = 0;
        for (int i = 1; i <= Math.sqrt(s); i++) {
            if (s % i == 0) {
                numerators[j] = i;
                j++;
            }
        }
        return numerators;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int n = input.nextInt();
        int m = input.nextInt();
        int s = input.nextInt();
        int k = input.nextInt();
        int[][] tile = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            tile[x - 1][y - 1] = 1;
        }
        int[] numerators = numerator(s);
        int flag = 1;
        for (int t = 0; t < numerators.length; t++) {
            if (numerators[t] != 0 && numerators[t] != s / numerators[t]) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i + numerators[t] - 1 < n && j + (s / numerators[t] - 1) < m) {
                            flag = 1;
                            for (int l = i; l < i + numerators[t]; l++) {
                                for (int o = j; o < j + s / numerators[t]; o++) {
                                    if (tile[l][o] == 1) {
                                        flag = 0;
                                        break;
                                    }
                                }
                            }
                            if (flag == 1)
                                counter++;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i + s / numerators[t] - 1 < n && j + numerators[t] - 1 < m) {
                            flag = 1;
                            for (int l = i; l < i + s / numerators[t]; l++) {
                                for (int o = j; o < j + numerators[t]; o++) {
                                    if (tile[l][o] == 1) {
                                        flag = 0;
                                    }
                                }
                            }
                            if (flag == 1)
                                counter++;
                        }
                    }
                }
            } else if (numerators[t] != 0 && numerators[t] == s / numerators[t]) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i + numerators[t] - 1 < n && j + (s / numerators[t] - 1) < m) {
                            flag = 1;
                            for (int l = i; l < i + numerators[t]; l++) {
                                for (int o = j; o < j + s / numerators[t]; o++) {
                                    if (tile[l][o] == 1) {
                                        flag = 0;
                                        break;
                                    }
                                }
                            }
                            if (flag == 1)
                                counter++;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
