import java.util.EmptyStackException;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> stack;

    public MyLinkedListStack() {
        stack = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }
}