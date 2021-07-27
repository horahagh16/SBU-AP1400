import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        String password = input.nextLine();
        String email = input.nextLine();
        String userid = input.nextLine();
        input.close();
        //pattern of username
        String regex1 = "^(?!.*[_.\\-]{2})([\\w\\.\\-\\_]){5,20}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(username);
        if (!matcher1.matches()) {
            System.out.println("Invalid username");
        }

        int flag = 1;
        int conNum = 0;
        char[] passArr = password.toCharArray();

        //3th condition of password
        if ((passArr[0] == 'a' || passArr[0] == 'b') && (passArr[1] == 'a' || passArr[1] == 'b')) {
            conNum = 1;
            for (int i = 0; i < passArr.length; i++) {
                if (passArr[i] == 'a' || passArr[i] == 'b') {
                    if ((i + 1) % 3 == 0 && passArr[i] != 'a') {
                        flag = 0;

                        break;
                    }
                    flag = 1;
                } else {
                    flag = 0;
                    break;
                }
            }
        }
        //1st condition of password
        if (((passArr[0] == '1' && password.length() % 2 == 0) || (passArr[0] == '0' && password.length() % 2 == 1)) && (passArr[1] == '1' || passArr[1] == '0')) {
            conNum = 1;
            for (int i = 0; i < passArr.length; i++) {
                if (passArr[i] == '1' || passArr[i] == '0') {
                    flag = 1;
                } else {
                    flag = 0;
                    break;
                }
            }
        }
        //2th condition of password
        if (conNum == 0) {
            String regex2 = "[uoiea]*.*u.*o.*i.*e.*a.*";
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(password);
            if (!matcher2.find())
                flag = 0;
        }

        if (flag == 0) {
            System.out.println("Invalid password");
            flag = 2;
        }

        //pattern of email was found in stackoverflow and set with conditions
        String regex3 = "^(?![.])(?:[a-z0-9_\\-]+(?:\\.[a-z0-9_\\-]+)*|\\\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\\\")" +
                "{0,64}@(?![-.])(?!.*[.]{2})(?:[a-zA-Z0-9_\\-]+\\.)+[a-zA-Z_\\-]{2,6}(?<![-.])$";

        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(email);
        if (!matcher3.matches()) {
            System.out.println("Invalid email address");
        }
        //pattern of userID
        String regex4 = "((1[0-9][1-9])+[0-9]{17})|((3[3][3-9][3-9])+[0-9]{16})|((3[4-9][0-8][0-9])+[0-9]{16}|(3990)+[0-9]{16})";
        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher(userid);
        if (!matcher4.matches()) {
            System.out.println("Invalid user ID");
        }

        //all is in correct format
        if (matcher1.matches() && matcher3.matches() && matcher4.matches() && flag != 2)
            System.out.println("Registration completed successfully");
    }
}