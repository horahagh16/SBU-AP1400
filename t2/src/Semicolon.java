import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Semicolon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String code = "";
        while (input.hasNextLine()) {
            code = input.nextLine();
            String regex1 = "^#.*$";//#comment
            String regex2 = "^[^#].*[^;]$";//code
            String regex3 = "^[^#].*#.*$";//code; #comment;
            String regex4 = "[^#]*.*;";//code;

            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(code);

            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(code);

            Pattern pattern3 = Pattern.compile(regex3);
            Matcher matcher3 = pattern3.matcher(code);

            Pattern pattern4 = Pattern.compile(regex4);
            Matcher matcher4 = pattern4.matcher(code);

            if (matcher3.matches()) {
                for (int i = 0; i < code.indexOf('#'); i++) {
                    if (code.charAt(i) == ';')
                        code = code.replaceFirst(";", "");
                }
            } else if (matcher2.matches() || matcher1.matches()) {
                code = code;
            } else if (matcher4.matches()) {
                code = code.replaceFirst(";", "");
            }
            System.out.println(code);
        }
    }
}
