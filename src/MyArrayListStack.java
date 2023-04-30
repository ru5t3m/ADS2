public class MyArrayListStack {
    private final MyArrayList arrayList;

    public MyArrayListStack(MyArrayList arrayList) {
        this.arrayList = arrayList;
    }
    public void push(Object e){
        arrayList.add(e);
    }
}