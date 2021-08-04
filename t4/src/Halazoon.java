import java.util.Scanner;

public class Halazoon {

    static void RecursivePrint(int[][] matrix, int i, int j, int m, int n) {
        //base condition
        if (i >= m || j >= n) {
            return;
        }
        int printer;
        for (printer = i; printer < n; printer++) {
            System.out.print(matrix[i][printer] + " ");
        }
        for (printer = i + 1; printer < m; printer++) {
            System.out.print(matrix[printer][n - 1] + " ");
        }
        if ((m - 1) != i) {
            for (printer = n - 2; printer >= j; printer--) {
                System.out.print(matrix[m - 1][printer] + " ");
            }
        }
        if ((n - 1) != j) {
            for (printer = m - 2; printer > i; printer--) {
                System.out.print(matrix[printer][j] + " ");
            }
        }
        RecursivePrint(matrix, i + 1, j + 1, m - 1, n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        RecursivePrint(matrix, 0, 0, m, n);
    }
}
