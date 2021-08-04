public class node {
    int value;
    node next;
    node(int value){
        this.value=value;
    }
}
class MyLinkedList{
    public static void main(String[] args) {
        node first=new node(0);
        node curent=first;
        for (int i = 1; i < 5; i++) {
            curent.next=new node(i);
            curent=curent.next;
        }
        //add new value

        node temp=new node(10);
        temp.next=first;
        first=temp;
        curent=first;
        while (curent!=null){
            System.out.println(curent.value);
            curent=curent.next;
        }
    }
}
