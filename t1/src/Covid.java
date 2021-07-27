import java.util.Scanner;

public class Covid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int masknum = input.nextInt();
        int kharid = input.nextInt();
        int biroon = masknum / 2;
        if (kharid == 1 && masknum >= 2)
            System.out.println("INF");
        else {
            if (masknum / 2 > kharid) {
                if (kharid == 1) {
                    System.out.println("INF");
                } else {
                    int day;
                    for (day = 1; day < biroon; ) {
                        if (day % kharid == 0) {
                            biroon++;
                        }
                        day++;
                        if (day % kharid == 0 && day == biroon) {
                            day++;
                            break;
                        }
                    }
                    System.out.println(day);
                }
            } else if (masknum / 2 == kharid) {
                System.out.println(masknum / 2 + 1);
            } else
                System.out.println(masknum / 2);
        }
    }
}