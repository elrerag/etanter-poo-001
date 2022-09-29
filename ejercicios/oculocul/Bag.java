class Runnable {
    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.extend(2);
        System.out.println(bag.merge(bag));
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

interface IBag {
    // returns true if this is the empty bag
    boolean isEmpty();
    // returns true if this bag contains i
    boolean contains(int i);
    // returns a new bag that extends this with i
    Bag extend(int i);
    // returns the size of this bag
    int length();
    // returns a new bag that is the merge of this and b
    Bag merge(Bag b);
}

public class Bag implements IBag {
    Node head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(int i) {
        Node n = head;
        boolean contains = false;
        if(head == null) {
            return contains;
        }
        while(n.next != null){
            if(i == n.data){
                contains = true;
            }
            n = n.next;
        }
        return contains;
    }

    @Override
    public Bag extend(int i) {
        IBag miBag = new Bag();
        ((Bag) miBag).head = this.head;
        Node aux = new Node(i);
        ((Bag) miBag).head.next = aux;
        if(head == null) {
            head = aux;
        }else {
            ((Bag) miBag).head = this.head;
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = aux;
        }

        return (Bag) miBag;
    }

    @Override
    public int length() {
        int length = 0;
        if(head == null){ return length;}
        Node n = head;
        while(n.next != null) {
            length++;
            n = n.next;
        }
        length++;

        return length;
    }

    @Override
    public Bag merge(Bag b) {
        if(head == null){ return b;}
        StringBuffer buffer = new StringBuffer();
        Node n = head;
        while(n.next != null) {
            buffer.append(String.valueOf(n.data));
            n = n.next;
        }
        buffer.append(String.valueOf(b));

        int data = Integer.parseInt(buffer.toString());
        IBag bag = new Bag();
        bag.extend(data);

        return (Bag) bag;
    }

}