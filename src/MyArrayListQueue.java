import java.util.NoSuchElementException;

public class MyArrayListQueue<T> {
    private MyArrayList<T> queue;

    public MyArrayListQueue() {
        queue = new MyArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

}