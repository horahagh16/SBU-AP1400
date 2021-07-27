import java.util.Scanner;

public class namad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int tool = number.length();
        number = number.concat("00000"); //tedade index ha dar adade koochak beham nakhorad.
        if (number.indexOf('.') == -1)//adad sahih
        {
            if (number.charAt(0) == '-')//adad manfi
            {
                System.out.println(number.substring(0, 2) + "." + number.substring(2, 4) + "E" + (tool -= 2));
            } else {

                System.out.println(number.substring(0, 1) + "." + number.substring(1, 3) + "E" + (--tool));
            }
        } else { //adad ashari
            if (number.charAt(0) == '-') { //adad manfi
                if (number.charAt(1) != '0') {
                    int dot = number.indexOf(".");
                    number = number.replace(".", "");
                    System.out.println(number.substring(0, 2) + "." + number.substring(2, 4) + "E" + (dot -= 2));
                } else { //-0.000000000119 i=12
                    int i;

                    for (i = 3; number.charAt(i) == '0'; i++) {
                    }
                    System.out.println("-" + number.substring(i, (i + 1)) + "." + number.substring((i + 1), (i + 3)) + "E-" + (i - 2));
                }
            } else {
                if (number.charAt(0) != '0') {
                    int dot = number.indexOf(".");
                    number = number.replace(".", "");
                    System.out.println(number.substring(0, 1) + "." + number.substring(1, 3) + "E" + (--dot));
                } else { //0.000000000119
                    int i;
                    for (i = 2; number.charAt(i) == '0'; i++) {
                    }
                    System.out.println(number.substring(i, (i + 1)) + "." + number.substring((i + 1), (i + 3)) + "E-" + (i - 1));
                }
            }
        }
    }
}