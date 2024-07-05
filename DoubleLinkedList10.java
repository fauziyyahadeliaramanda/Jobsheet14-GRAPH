public class DoubleLinkedList10 {
    Node10 head;
    int size;

public DoubleLinkedList10(){
    head = null;
    size = 0;
}
public boolean isEmpty(){
    return head == null;
}
public void addFirst(int item, int jarak) {
if (isEmpty()){
    head = new Node10(null, item, jarak, null);
} else {
    Node10 newNode = new Node10(null, item, jarak, head);
    head.prev = newNode;
    head = newNode;
}
size++;
}
public void addLast(int item){
    if(isEmpty()){
        addLast(item);
    } else {
        Node10 current = head;
        while (current.next !=null){
            current = current.next;
        }
        Node10 newNode = new Node10 (current, item, item, null);
        current.next = newNode;
        size++;
    }
  }
  public void add(int item, int index) throws Exception {
    if (isEmpty()){
        addLast(item);
    } else if (index < 0 || index > size) {
        throw new Exception("Nilai indeks di luar batas");
    } else {
        Node10 current = head;
        int i = 0;
        while (i < index) {
            i++;
        }
        if(current.prev == null) {
            Node10 newNode = new Node10 (null, item, i, current);
            current.prev = newNode;
            head = newNode;
        } else {
            Node10 newNode = new Node10 (current.prev, item, i, current);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }
    size++;
  }
  public int size() {
    return size;
  }
  public void clear() {
    head = null;
    size = 0;
  }
  public void print(){
    if(!isEmpty()){
        Node10 tmp = head;
        while (tmp !=null){
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println("\nberhasil diisi"); 
    } else {
        System.out.println("Linked Lists Kosong");
    }
  }
  public void removeFirst() throws Exception {
    if(isEmpty()){
        throw new Exception ("Linked List masih kosong, tidak dapat dihapus!");
    } else if (size == 1) {
        removeFirst();
    } else {
        head = head.next;
        head.prev = null;
        size--;
    }
  }
  public void removeLast() throws Exception {
    if(isEmpty()){
        throw new Exception ("Linked List masih kosong, tidak dapat dihapus!");
    } else if (head.next == null) {
        head = null;
        size--;
        return;
    } 
    Node10 current = head;
    while (current.next.next != null){
        current = current.next;
    }
    current.next = null;
    size--;
  }
    public void remove (int index) {
       Node10 current = head;
        while (current != null){
            if (current.data == index) {
                if(current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }
    public int getFirts() throws Exception {
        if(isEmpty()) {
            throw new Exception ("Linked List kosong");
        }
        return head.data;
    }  
    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception ("Linked List Kosong");
        }
        Node10 tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public int getJarak(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception ("Nilai indeks di luar batas");
        }
        Node10 tmp = head;
        for (int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.jarak;
    }
    public int get (int index) throws Exception{
        if(isEmpty() || index >=size) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        Node10 tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
