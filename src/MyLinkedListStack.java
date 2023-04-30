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

}