import java.util.HashSet;
import java.util.*;

public class col3 {
    public static void main(String[] args) {
        String[] book={"binavayan","samphony mordegan","chashmhayash","binavayan","binavayan"};
        Set as=new HashSet();
        LinkedHashSet lh=new LinkedHashSet();
        TreeSet ts=new TreeSet();
        for (int i = 0; i < book.length; i++) {
            as.add(book[i]);
            lh.add(book[i]);
            ts.add(book[i]);
        }
        System.out.print("Array is: ");
        for (int i = 0; i < book.length; i++) {
            System.out.print(book[i]+" ");
        }
        System.out.println();
        Iterator iterator = as.iterator();
        Iterator iterator2 = lh.iterator();
        Iterator iterator3 = lh.iterator();
        System.out.println("hash set: ");
        while (iterator.hasNext()) {
            //ignore repeat in array
            //mixed items
            System.out.println(iterator.next());
        }
        System.out.println("linked hash set: ");
        while (iterator2.hasNext()) {
            //ignore repeat in array
            //without sort like input array
            System.out.println(iterator2.next());
        }
        System.out.println("tree set: ");
        while (iterator3.hasNext()) {
            //ignore repeat in array
            //sort by name
            System.out.println(iterator3.next());
        }
    }
}
