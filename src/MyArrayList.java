public class MyArrayList<T> implements MyList<T> {
    private Object[] MyArrayListElem;
    private int size;
    private static final int CAPACITY = 10;

    public MyArrayList() {
        MyArrayListElem = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(MyArrayListElem[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        if (size == MyArrayListElem.length) {
            Object[] newElem = new Object[MyArrayListElem.length * 2];
            for (int i = 0; i < MyArrayListElem.length; i++) {
                newElem[i] = MyArrayListElem[i];
            }
            MyArrayListElem = newElem;
        }
        MyArrayListElem[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index is out of bounds");
        }
        if (size == MyArrayListElem.length) {
            Object[] newElem = new Object[MyArrayListElem.length * 2];
            for (int i = 0; i < MyArrayListElem.length; i++) {
                newElem[i] = MyArrayListElem[i];
            }
            MyArrayListElem = newElem;
        }
        for (int i = size; i > index; i--) {
            MyArrayListElem[i] = MyArrayListElem[i - 1];
        }
        MyArrayListElem[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        if (contains(item)){
            int index = 0;
            Object[] newElem = new Object[CAPACITY];
            for(int i = 0; i<size; i++){
                if (!MyArrayListElem[i].equals(item)){
                    newElem[index] = MyArrayListElem[i];
                    index++;
                }
            }
            MyArrayListElem = newElem;
            size--;
            return true;
        }
        else {
            return false;
        }
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