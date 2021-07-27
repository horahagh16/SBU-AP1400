import java.util.Scanner;

public class Unicode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String character = input.nextLine();
        int code = character.codePointAt(0);
        System.out.println(code);
        if (code > 1569 && code < 1741) {
            System.out.println("persian");
        } else
            System.out.println("not-persian");
    }
}