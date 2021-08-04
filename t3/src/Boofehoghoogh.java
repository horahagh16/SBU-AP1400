import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boofehoghoogh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        String[] saf = new String[n];
        String regex1 = "enqueue";
        String regex2 = "dequeue";
        while (input.hasNext()) {
            String order = input.next();
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(order);
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(order);
            if (matcher1.matches()) {
                n++;
                String[] temp = new String[n];
                for (int j = 0; j < n - 1; j++) {
                    temp[j] = saf[j];
                }
                temp[n - 1] = input.nextLine();
                saf = temp;
            } else if (matcher2.matches()) {
                if (n == 0) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println(saf[0].trim());
                    n--;
                    String[] temp = new String[n];
                    for (int j = 0; j < n; j++) {
                        temp[j] = saf[j + 1];
                    }
                    saf = temp;
                }
            } else
                System.out.println("Dadach dari eshtebah mizani");
        }
    }
}