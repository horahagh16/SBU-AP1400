import java.util.*;

public class student implements Comparable<student> {
    int sid;

    student(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return sid + " ";
    }

    @Override
    public int compareTo(student o) {
        return this.sid - o.sid;

    }
}

class StuTreeSet {
    public static void main(String[] args) {
        TreeSet stu = new TreeSet();
        student s1 = new student(11);
        student s2 = new student(22);
        student s3 = new student(33);
        stu.add(s1);
        stu.add(s2);
        stu.add(s3);

        Iterator iterator = stu.iterator();
        while (iterator.hasNext()) {
            //ignore repeat in array
            //mixed items
            System.out.println(iterator.next());
        }
    }
}