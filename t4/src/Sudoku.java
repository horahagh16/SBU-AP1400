import java.util.Scanner;

public class Sudoku {

    static boolean checkRepeat(int[][] arr, int size) {
        //check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (arr[i][j] == arr[i][k])
                        return false;
                }
            }
        }
        //check column
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                for (int k = i + 1; k < size; k++) {
                    if (arr[i][j] == arr[k][j])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = input.nextInt();
            }
        }
        if (checkRepeat(table, size)) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
