import java.util.Arrays;
import java.util.Scanner;

public class aghigh {
    static boolean checkSameDiag(int board[][]) {
        //int[] diag = new int[8];
        int counter;
        for (int i = 0; i < 7; i++) {
            counter = 0;
            for (int j = i; j < 8; j++) {
                counter += board[j][j - i];
            }
            if (counter > 1) {
                return true;
            }
        }

        for (int i = 1; i < 7; i++) {
            counter = 0;
            for (int j = i; j < 8; j++) {
                counter += board[j][7 - j + i];
            }
            if (counter > 1) {
                return true;
            }
        }

        for (int i = 7; i > 0; i--) {
            counter = 0;
            for (int j = i; j >= 0; j--) {
                counter += board[j][i - j];
            }
            if (counter > 1) {
                return true;
            }
        }

        for (int i = 1; i < 7; i++) {
            counter = 0;
            for (int j = i; j >= 0; j--) {
                counter += board[j][7 + j - i];
            }
            if (counter > 1) {
                return true;
            }
        }
        return false;
    }

    static void threaten(int[][] board, char type) {
        int flag = 0;
        switch (type) {
            case 'K': //find L
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (board[i][j] == 1) {
                            if (i > 1 && i < 6 && j > 1 && j < 6) {
                                if (board[i + 2][j + 1] == 1 ||
                                        board[i + 2][j - 1] == 1 ||
                                        board[i - 2][j + 1] == 1 ||
                                        board[i - 2][j - 1] == 1 ||
                                        board[i + 1][j + 2] == 1 ||
                                        board[i - 1][j + 2] == 1 ||
                                        board[i + 1][j - 2] == 1 ||
                                        board[i - 1][j - 2] == 1) {
                                    flag = 1;
                                    break;
                                }
                            } else if ((i > 1 && i < 6) && (j == 1 || j == 6)) {
                                if (board[i + 2][j + 1] == 1 ||
                                        board[i + 2][j - 1] == 1 ||
                                        board[i - 2][j + 1] == 1 ||
                                        board[i - 2][j - 1] == 1 ||
                                        (j == 1 && board[i + 1][j + 2] == 1) ||
                                        (j == 1 && board[i - 1][j + 2] == 1) ||
                                        (j == 6 && board[i + 1][j - 2] == 1) ||
                                        (j == 6 && board[i - 1][j - 2] == 1)) {
                                    flag = 1;
                                    break;
                                }
                            } else if (j > 1 && j < 6 && (i == 1 || i == 6)) {
                                if (board[i + 1][j + 2] == 1 ||
                                        board[i - 1][j + 2] == 1 ||
                                        board[i + 1][j - 2] == 1 ||
                                        board[i - 1][j - 2] == 1 ||
                                        (i == 1 && (board[i + 2][j + 1] == 1 || board[i + 2][j - 1] == 1)) ||
                                        (i == 6 && (board[i - 2][j + 1] == 1 || board[i - 2][j - 1] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            } else if (i > 1 && i < 6) {
                                if ((j == 0 && (board[i + 2][j + 1] == 1 || board[i - 2][j + 1] == 1 || board[i + 1][j + 2] == 1 ||
                                        board[i - 1][j + 2] == 1)) ||
                                        (j == 7 && (board[i + 2][j - 1] == 1 || board[i - 2][j - 1] == 1 || board[i + 1][j - 2] == 1 ||
                                                board[i - 1][j - 2] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            } else if (j > 1 && j < 6) {
                                if ((i == 0 && (board[i + 2][j + 1] == 1 || board[i + 2][j - 1] == 1 || board[i + 1][j + 2] == 1 || board[i + 1][j - 2] == 1)) ||
                                        (i == 7 && (board[i - 2][j + 1] == 1 || board[i - 2][j - 1] == 1 || board[i - 1][j + 2] == 1 || board[i - 1][j - 2] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            } else if (i == 0) {
                                if ((j == 0 && (board[2][1] == 1 || board[1][2] == 1)) ||
                                        (j == 1 && (board[i + 2][j + 1] == 1 || board[i + 2][j - 1] == 1 || board[i + 1][j + 2] == 1)) ||
                                        (j == 6 && (board[i + 2][j + 1] == 1 || board[i + 2][j - 1] == 1 || board[i + 1][j - 2] == 1)) ||
                                        (j == 7 && (board[1][5] == 1 || board[2][6] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            } else if (i == 1) {
                                if ((j == 0 && (board[0][2] == 1 || board[3][1] == 1 || board[2][2] == 1)) ||
                                        (j == 1 && (board[3][0] == 1 || board[0][3] == 1 || board[2][3] == 1 || board[3][2] == 1)) ||
                                        (j == 6 && (board[0][4] == 1 || board[2][4] == 1 || board[3][5] == 1 || board[3][7] == 1)) ||
                                        (j == 7 && (board[0][5] == 1 || board[2][5] == 1 || board[3][6] == 1))
                                ) {
                                    flag = 1;
                                    break;
                                }
                            } else if (i == 6) {
                                if ((j == 0 && (board[4][1] == 1 || board[5][2] == 1 || board[7][2] == 1)) ||
                                        (j == 1 && (board[4][0] == 1 || board[4][2] == 1 || board[5][3] == 1 || board[7][3] == 1)) ||
                                        (j == 6 && (board[4][5] == 1 || board[4][7] == 1 || board[5][4] == 1 || board[7][4] == 1)) ||
                                        (j == 7 && (board[4][6] == 1 || board[5][5] == 1 || board[7][5] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            } else {
                                if ((j == 0 && (board[5][1] == 1 || board[6][2] == 1)) ||
                                        (j == 1 && (board[i - 2][j + 1] == 1 || board[i - 2][j - 1] == 1 || board[i - 1][j + 2] == 1)) ||
                                        (j == 6 && (board[i - 2][j + 1] == 1 || board[i - 2][j - 1] == 1 || board[i - 1][j - 2] == 1)) ||
                                        (j == 7 && (board[6][5] == 1 || board[5][6] == 1))) {
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (flag == 1) {
                        break;
                    }
                }
                break;
            case 'B'://completed
                if (checkSameDiag(board))
                    flag = 1;
                break;
            case 'R'://completed
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (board[i][j] == 1) {
                            for (int k = 0; k < 8; k++) {
                                if (k != j && board[i][k] == 1) {
                                    flag = 1;
                                    break;
                                }
                            }
                            for (int k = 0; k < 8; k++) {
                                if (k != i && board[k][j] == 1) {
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                        if (flag == 1)
                            break;
                    }
                    if (flag == 1)
                        break;
                }
                break;
        }
        if (flag == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char type = input.next().charAt(0);
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = input.nextInt();
            }
        }
        threaten(board, type);
    }

}
