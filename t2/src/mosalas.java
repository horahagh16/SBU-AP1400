import java.util.Scanner;

public class mosalas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        for (int i = 0; i < rows; i++) {
            int alphabet = 65;
            for (int j = rows - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = i; k >= 0; k--) {
                System.out.print((char) (alphabet + k));
            }
            for (int l = 1; l <= i; l++) {
                System.out.print((char) (alphabet + l));
            }
            System.out.println();
        }
    }
}