import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    private MyLinkedList<T> queue;

    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }
}