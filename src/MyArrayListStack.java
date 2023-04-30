import java.util.EmptyStackException;

public class MyArrayListStack<T> {
    private MyArrayList<T> stack;

    public MyArrayListStack() {
        stack = new MyArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }
}