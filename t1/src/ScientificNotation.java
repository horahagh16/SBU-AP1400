import java.util.Scanner;

public class ScientificNotation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        int index = num.indexOf('.');
        double number = Double.parseDouble(num);//reshte -> adad
        if (index == -1) { //adade sahih
            if ((number >= 1 && number < 10) || (number > -10 && number <= -1)) {
                System.out.printf("%.2fE0", number);
            } else {
                int j = 0;
                while (number >= 10 || number <= -10) {
                    number *= 0.1;
                    j++;
                }
                num = String.format("%f", number);
                if (num.charAt(0) != '-')
                    System.out.println(num.substring(0, 1) + "." + num.substring(2, 4) + "E" + j);
                else if (num.charAt(0) == '-')
                    System.out.println(num.substring(0, 2) + "." + num.substring(3, 5) + "E" + j);
            }
        } else {

            if (number < 1 && number > -1) {
                int i = 0;
                while (number < 1 && number > -1) {
                    number *= 10;
                    i++;
                }
                num = String.format("%f", number);//adad->reshte
                if (num.charAt(0) == '-')
                    System.out.println(num.substring(0, 5) + "E" + "-" + i);
                else
                    System.out.println(num.substring(0, 4) + "E" + "-" + i);

            } else if ((number >= 1 && number < 10) || (number > -10 && number <= -1)) {

                num = String.format("%f", number);//adad->reshte
                if (num.charAt(0) == '-')
                    System.out.println(num.substring(0, 5) + "E" + "0");
                else
                    System.out.println(num.substring(0, 4) + "E" + "0");
            } else {
                index--;
                num = String.format("%f", number);//adad->reshte
                num = num.replace(".", "");
                if (num.charAt(0) != '-')
                    System.out.println(num.substring(0, 1) + "." + num.substring(1, 3) + "E" + index);
                else if (num.charAt(0) == '-')
                    System.out.println(num.substring(0, 2) + "." + num.substring(2, 4) + "E" + --index);
            }
        }
    }
}