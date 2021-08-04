import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t91 {

    static List<page> pages = new ArrayList<>();

    public static void main(String[] args) {
        page p1 = new page("my-first-post");
        page p2 = new page("my-second-post");
        pages.add(p1);
        pages.add(p2);
        Scanner input = new Scanner(System.in);
        while (true) {
            String order = input.next();
            String pge = input.next();
            if (order.equals("increment_visits_count")) {
                for (page page : pages) {
                    if (pge.equals(page.getname()))
                        page.setVisits();
                }

            } else if (order.equals("get_visits_count")) {
                for (page page : pages) {
                    if (pge.equals(page.getname()))
                        System.out.println(page.getVisits());
                }
            } else if (order.equals("get_all_visits_count")) {
                int sum = 0;
                for (int i = 0; i < pages.size(); i++) {
                    sum = sum + pages.get(i).getVisits();
                }
                System.out.println(sum);
            } else if (order.equals("end")) {
                break;
            }
        }
    }
}

class page {
    private int visits = 0;
    private String name;

    page(String name) {
        this.name = name;
    }

    String getname() {
        return name;
    }


    int getVisits() {
        return visits;
    }

    void setVisits() {
        visits++;
    }

}