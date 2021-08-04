import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class collections1 {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList();
        CopyOnWriteArrayList<String> copyOnWriteArrayList=new CopyOnWriteArrayList<String>();
        Collections.synchronizedList(arr1);
        arr1.add("text1");
        arr1.add("text2");
        arr1.add("text3");
        synchronized (arr1) {
            Iterator it = arr1.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
        }
    }
}
