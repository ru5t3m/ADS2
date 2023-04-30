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
        if (index < 0 || index >= size){
            System.out.println("Index is out of bounds");
        }
        else {
            int indexInside = 0;
            Object[] newElem = new Object[CAPACITY];
            for(int i = 0; i < size; i++){
                if (i == index){
                    continue;
                }
                newElem[indexInside] = MyArrayListElem[i];
                indexInside++;
            }
            size--;
            MyArrayListElem = newElem;
            return (T) MyArrayListElem;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            MyArrayListElem[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of bounds");
        }
        return (T) MyArrayListElem[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(MyArrayListElem[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(MyArrayListElem[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        for(int i = 1; i<size;i++){
            Object a = MyArrayListElem[i];
            int j = i;
            while (j >= 0 && ((Comparable) MyArrayListElem[j]).compareTo(a) > 0){
                MyArrayListElem[j] = MyArrayListElem[j-1];
                j = j -2;
            }
            MyArrayListElem[j] = a;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}