import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = "";
        while (input.hasNextLine()) {
            text = input.next();
            String date = "\\d\\d\\d\\d/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[0])";
            Pattern pattern1 = Pattern.compile(date);
            Matcher matcher1 = pattern1.matcher(text);
            if (matcher1.find()) {
                String temp = text;
                Matcher matcher2 = pattern1.matcher(temp);
                if (matcher2.matches())
                    System.out.println(text);
            }
        }
    }
}
