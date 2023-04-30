import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    private MyLinkedList<T> queue;

    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }

    public int size() {
        return queue.size();
    }

}