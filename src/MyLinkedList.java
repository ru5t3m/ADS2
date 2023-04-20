public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node nowHead = head;
        int nowIndex = 0;
        int k = 0;
        while (nowIndex<size){
            if (nowHead.data.equals(o)) {
                k = 1;
                break;
            }
            nowIndex++;
            nowHead = nowHead.next;
        }
        return k == 1;
    }

    @Override
    public void add(T item) {
        Node currNode = new Node(item);

        if (head == null && tail == null){
            head = currNode;
        }else{
            tail.next = currNode;
            currNode.prev = tail;
        }
        tail = currNode;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
        }
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;

    }

    @Override
    public boolean remove(T item) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {
    }
}
