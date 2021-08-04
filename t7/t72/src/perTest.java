import java.util.*;

public class perTest {
    public static void main(String[] args) {
        LinkedHashSet lh=new LinkedHashSet();
        TreeSet ts=new TreeSet();
        HashSet hs=new HashSet();
        long starttime=System.nanoTime();
        for (int i = 0; i <100 ; i++) {
            int num= (int) (Math.random()*10);
            hs.add(num);
        }
        long endtime=System.nanoTime();
        long time=starttime-endtime;
        System.out.println("Hashset: "+time);

        long starttime2=System.nanoTime();
        for (int i = 0; i <100 ; i++) {
            int num= (int) (Math.random()*10);
            ts.add(num);
        }
        long endtime2=System.nanoTime();
        long time2=starttime2-endtime2;
        System.out.println("treeset: "+time2);

        long starttime3=System.nanoTime();
        for (int i = 0; i <100 ; i++) {
            int num= (int) (Math.random()*10);
            lh.add(num);
        }
        long endtime3=System.nanoTime();
        long time3=starttime3-endtime3;
        System.out.println("linked: "+time3);
    }
}
