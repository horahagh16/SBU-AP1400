import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathGame {
    public static int CastToNum(String num, int counter) {
        char[] arr = new char[counter];
        arr = num.toCharArray();
        int number = 0;
        for (int i = 0; i < counter; i++) {
            number = number * 10 + (arr[i] - '0');
        }
        return number;
    }

    public static int howManyNum(int n) {
        int counter = 0, x;
        while (n > 0) {
            x = n % 10;
            counter++;
            n = n / 10;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String equation = input.nextLine();
        int counter1 = 0;//adade aval chan raghami?
        int counter2 = 0;//adade dovo chan raghami?
        int counter3 = 0;//adade javab chan raghami?
        for (int i = 0; equation.charAt(i) != '-'; i++) {
            counter1++;
        }
        String x = equation.substring(0, counter1);
        int minus = equation.indexOf('-');
        int equal = equation.indexOf('=');
        for (int i = minus + 1; equation.charAt(i) != '='; i++) {
            counter2++;
        }
        String y = equation.substring(minus + 1, minus + 1 + counter2);
        for (int i = equal + 1; i < equation.length(); i++) {
            counter3++;
        }
        String z = equation.substring(equal + 1, equal + 1 + counter3);
        String regex = "[#]";
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(x);
        Matcher matcher2 = pattern1.matcher(y);
        Matcher matcher3 = pattern1.matcher(z);
        int second = 0, ans = 0, first = 0, flag = 2;
        if (matcher1.find()) { //x maloom nist
            second = CastToNum(y, counter2);
            ans = CastToNum(z, counter3);
            first = second + ans;
            String newx = Integer.toString(first);
            if (matcher1.matches())//faghat#
                flag = 1;
            else {
                if ((x.charAt(0) == newx.charAt(0) || x.charAt(x.length() - 1) == newx.charAt(newx.length() - 1)) && howManyNum(first) >= counter1)

                    flag = 1;
                else
                    flag = 0;
            }

        } else if (matcher2.find()) { //y maloom nist
            first = CastToNum(x, counter1);
            ans = CastToNum(z, counter3);
            second = first - ans;
            String newy = String.valueOf(second);
            if (matcher2.matches())//faghat#
                flag = 1;
            else {
                if ((y.charAt(0) == newy.charAt(0) || y.charAt(y.length() - 1) == newy.charAt(newy.length() - 1)) && howManyNum(second) >= counter2)
                    flag = 1;
                else
                    flag = 0;
            }

        } else if (matcher3.find()) {//z maloom nist
            first = CastToNum(x, counter1);
            second = CastToNum(y, counter2);
            ans = first - second;
            String newz = String.valueOf(ans);
            if (matcher3.matches())//faghat#
                flag = 1;
            else {
                if ((z.charAt(0) == newz.charAt(0) || z.charAt(z.length() - 1) == newz.charAt(newz.length() - 1)) && howManyNum(ans) >= counter3)
                    flag = 1;
                else
                    flag = 0;
            }
        }
        if (first < 0 || second < 0 || ans < 0) {
            flag = 0;
        }
        if (flag == 0) {
            System.out.println("Wrong Equation");
        } else
            System.out.println(first + "-" + second + "=" + ans);
    }
}