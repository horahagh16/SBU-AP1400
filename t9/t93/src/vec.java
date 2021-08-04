import java.util.Vector;

public class vec {
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        for (int i = 0; i <14; i++) {
            v.addElement(i);
        }
        System.out.println(v.capacity());
        for (int i = 14; i <24; i++) {
            v.addElement(i);
        }
        System.out.println(v.capacity());
    }
}
