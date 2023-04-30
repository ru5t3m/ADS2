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
        while (nowIndex < size) {
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

        if (head == null && tail == null) {
            head = currNode;
        } else {
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
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
        }
        Node nowNode = head;
        for (int i = 0; i < index; i++) {
            nowNode = nowNode.next;
        }
        T data = nowNode.data;
        if (nowNode == head) {
            head = nowNode.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (nowNode == tail) {
            tail = nowNode.prev;
            tail.next = null;
        } else {
            nowNode.prev.next = nowNode.next;
            nowNode.next.prev = nowNode.prev;
        }
        size--;
        return data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        Node nowNode = head;
        int nowIndex = 0;

        while (nowIndex < index) {
            nowNode = nowNode.next;
            nowIndex++;
        }

        return nowNode.data;
    }

    @Override
    public int indexOf(Object o) {
        Node nowNode = head;
        for (int i = 0; i < size; i++) {
            if (nowNode.data.equals(o)) {
                return i;
            }
            nowNode = nowNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node nowNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (nowNode.data.equals(o)) {
                return i;
            }
            nowNode = nowNode.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        Node current = head.next;
        while (current != null) {
            T data = current.data;
            Node previous = current.prev;
            while (previous != null && ((Comparable) previous.data).compareTo(data) > 0) {
                previous.next.data = previous.data;
                previous = previous.prev;
            }
            if (previous == null) {
                head.data = data;
            } else {
                previous.next.data = data;
            }
            current = current.next;
        }
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst() {
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public T getFirst() {
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

