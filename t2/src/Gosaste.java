import java.util.Scanner;

public class Gosaste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ebarat = input.nextLine();
        char[] strArr = new char[0];
        if (ebarat.indexOf('∨') != -1) {
            ebarat = ebarat.replace('∨', '+');
        }
        if (ebarat.indexOf('∧') != -1) {
            ebarat = ebarat.replace("∧", "");
        }
        if (ebarat.contains("'")) {
            int loc = ebarat.indexOf("'");
            ebarat = ebarat.replace(ebarat.charAt(loc), '~'); //(....)' -> (....)~
            for (int i = ebarat.length() - 1; i > 0; i--) {
                if (ebarat.charAt(i) == '~' && ebarat.charAt(i - 1) == ')') {
                    for (int j = i; j >= 0; --j) {
                        if (ebarat.charAt(j) == '(') {
                            ebarat = ebarat.substring(0, j) + "~" + ebarat.substring(j, i) + ebarat.substring(i + 1);
                            break;
                        }
                    }
                }
            }
            strArr = ebarat.toCharArray();
            for (int i = 1; i <= strArr.length - 1; i++) { //p~ -> ~p
                if (strArr[i] == '~') {
                    if (i != 0 && strArr[i - 1] != ')') {
                        if (i != strArr.length - 1 && strArr[i + 1] != '(') {
                            char temp;
                            temp = strArr[i];
                            strArr[i] = strArr[i - 1];
                            strArr[i - 1] = temp;
                        }
                        if (i == strArr.length - 1) {
                            char temp;
                            temp = strArr[i];
                            strArr[i] = strArr[i - 1];
                            strArr[i - 1] = temp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i]);
        }
    }
}