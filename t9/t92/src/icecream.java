import java.util.*;

public class icecream {
    static int ic = 0;
    static List<buyer> buyers = new ArrayList<>();
    static int sold = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String order = input.next();

            if (order.equals("a")) {
                ic += input.nextInt();
            } else if (order.equals("s")) {
                if (buyers.size() == 0)
                    System.out.println("empty");
                else
                    System.out.println(buyers.size());
            } else if (order.equals("p")) {
                System.out.println(sold);
            } else if (order.equals("e")) {
                buyer buyer = new buyer();
                buyer.like = input.nextInt();
                buyer.num = input.nextInt();
                buyers.add(buyer);
                for (int i = 1; i < buyers.size(); ++i) {
                    int key = buyers.get(i).like;
                    int j = i - 1;
                    while (j >= 0 && buyers.get(j).like > key) {
                        buyers.get(j + 1).like = buyers.get(j).like;
                        j = j - 1;
                    }
                    buyers.get(j + 1).like = key;
                }
            } else if (order.equals("b")) {
                if (buyers.get(buyers.size() - 1).num < ic + 1) {
                    sold += buyers.get(buyers.size() - 1).num;
                    ic -= buyers.get(buyers.size() - 1).num;
                } else {
                    sold += ic;
                    ic = 0;
                }
                buyers.remove(buyers.size() - 1);
            } else if (order.equals("r")) {
                break;
            }
        }
    }
}

class buyer {
    int like;
    int num;
}
