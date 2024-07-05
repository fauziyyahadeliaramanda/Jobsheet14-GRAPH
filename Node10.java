public class Node10 {
    int data;
    Node10 prev, next;
    int jarak;

    Node10(Node10 prev, int data, int jarak, Node10 next) {
        this.prev=prev;
        this.data=data;
        this.next=next;
        this.jarak = jarak;
    }
}