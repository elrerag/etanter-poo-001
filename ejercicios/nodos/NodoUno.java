interface List {
    void insert(int data);
    void insertAt(int position, int data);
    void delete(int data);
    void show();
}

public class NodoUno {
    int data;
    NodoUno next;

    NodoUno(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    boolean hasNext() {
        return next != null;
    }

    NodoUno getNext() {
        return next;
    }

    void setNext(NodoUno next){
        this.next = next;
    }
}

class MiLista implements List {
    NodoUno head;

    @Override
    public void insert(int data) {
        NodoUno aux = new NodoUno(data);
        if(head == null) {
            head = aux;
        }else {
            NodoUno n = head;
            while(n.hasNext()){
                n = n.getNext();
            }
            n.setNext(aux);
        }
    }

    @Override
    public void insertAt(int position, int data) {
        // NodoUno aux = new NodoUno(data);
        // if(head == null) {
        //     head = aux;
        // }else {
        //     NodoUno n = head;
        //     for(int i = 0; i < n.length(); i++) {

        //     }


        //     while(n.hasNext()){
        //         n = n.getNext();
        //     }
        //     n.setNext(aux);
        // }

    }

    @Override
    public void delete(int data) {
        // TODO Auto-generated method stub
    }

    @Override
    public void show() {
        NodoUno node = this.head;

        while(node.hasNext()){
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println(node.getData());
    }

}

class Runner {
    public static void main(String[] args) {
        List milista = new MiLista();
        milista.insert(5);
        milista.insert(10);
        milista.insert(233);
        milista.insert(23);
        milista.insert(5345);
        milista.insert(346546);
        milista.insert(5435);
        milista.insert(24234);
        milista.insert(10);
        milista.insert(423432);
        milista.show();
    }
}