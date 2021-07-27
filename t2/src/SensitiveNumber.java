import java.util.Scanner;

public class SensitiveNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int flag = 1;
        int counter = 0;
        int length = number.length();
        if (number.indexOf('2') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '2') {
                    counter++;
                }
            }
            if (counter % 2 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('3') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '3') {
                    counter++;
                }
            }
            if (counter % 3 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('4') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '4') {
                    counter++;
                }
            }
            if (counter % 4 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('5') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '5') {
                    counter++;
                }
            }
            if (counter % 5 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('6') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '6') {
                    counter++;
                }
            }
            if (counter % 6 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('7') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '7') {
                    counter++;
                }
            }
            if (counter % 7 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('8') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '8') {
                    counter++;
                }
            }
            if (counter % 8 != 0)
                flag = 0;
            counter = 0;
        }
        if (number.indexOf('9') != -1) {
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '9') {
                    counter++;
                }
            }
            if (counter % 9 != 0)
                flag = 0;
            counter = 0;
        }
        if (flag == 1)
            System.out.println("Yes");
        else if (flag == 0)
            System.out.println("No");
    }
}