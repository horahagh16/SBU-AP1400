import java.util.*;

public class col2 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        Vector vc=new Vector(3,2);
        System.out.println(vc.capacity());
        vc.add("hora");
        vc.addElement("haghighatkhah");
        vc.add("hora");
        vc.add("haghighatkhah");
        ll.add("hora");
        ll.add("haghighatkhah");
        System.out.println(vc.capacity());
        Iterator iterator = ll.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

