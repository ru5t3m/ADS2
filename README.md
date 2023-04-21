# MyArrayList Class
## The MyArrayList class is an implementation of the MyList interface that uses an array to store its elements. The class provides methods to manipulate the elements in the array.

# Class Overview
## The MyArrayList class is defined as follows:

``` java
public class MyArrayList<T> implements MyList<T> {
    private Object[] MyArrayListElem;
    private int size;
    private static final int CAPACITY = 10;

    public MyArrayList() {
        MyArrayListElem = new Object[CAPACITY];
        size = 0;
    }
    
    // methods
}
```

## Fields:

``` MyArrayListElem ``` : an array that holds all the elements of created List.
``` size ``` : the number of elements inside, or the actual size.
``` CAPACITY ``` : the maximum capacity of an ArrayList.

## Constructor: 
``` MyArrayList() ``` : creates a new instance of the ```MyArrayList``` class with an initial capacity of ```CAPACITY``` and an empty list of elements.

# Class Methods:

## ```size()```
Returns the number of elements in the list.

``` java
public int size() {
    return size;
}
```

## contains(Object o)
Returns ```true``` if the list contains the specified element, ```false``` otherwise.

``` java
public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
        if (o.equals(MyArrayListElem[i])) {
            return true;
        }
    }
    return false;
}
```

## add(T item)
Adds the specified element to the end of the list. If the list is full, the capacity of the list is doubled.

``` java
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
```

## add(T item, int index)
Inserts the specified element at the specified position in the list. If the list is full, the capacity of the list is doubled. If the index is out of bounds, an error message is printed.

``` java
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
```

## remove(T item)
Removes the first occurrence of the specified element from the list. If the element is not found, nothing is done.

``` java
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
```

## remove(int index)
Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.

``` java
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
```

## clear()
Removes all of the elements from this list.

``` java
public void clear() {
        for (int i = 0; i < size; i++) {
            MyArrayListElem[i] = null;
        }
        size = 0;
    }
```

## get(int index)
Returns the element at the specified position in this list.

``` java
public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of bounds");
        }
        return (T) MyArrayListElem[index];
    }
```

## indexOf(Object o)
Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

``` java 
public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(MyArrayListElem[i])) {
                return i;
            }
        }
        return -1;
    }
```

## lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

``` java
public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(MyArrayListElem[i])) {
                return i;
            }
        }
        return -1;
    }
```

## sort()
Sorts the elements of this list in ascending order according to their natural ordering.

``` java
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
```


_______________________________________________________________________________________________________________________________________________________

# A class called MyLinkedList.
## MyLinkedList is a personalized version of the List interface that enables the arrangement and handling of elements in a sequential manner. The class employs a data structure that is doubly linked, facilitating immediate access to both the initial and final elements, and access to any element by index at a linear pace.

### The Inner Class of a Node.
Within the MyLinkedList class, there exists a Node class that is kept private and functions as a representation of a linked list node. Every single node possesses a T type element along with pointers that indicate the succeeding and preceding nodes in the specified list.

Variables that are declared within a class and can be accessed and modified by any method within that class are called instance variables.
Within MyLinkedList, the following variables are defined as instances:

### head: A reference to the first node in the list.
### tail: A reference to the last node in the list.
### size: The number of elements in the list.
## Methods
### MyLinkedList implements the following methods:

Obtain the count of elements within the list through the use of the ```size()``` function.

This method, ```contains(Object o)```, will yield a true result if the element specified is present in the list.

The function ```add(T item)``` is used to place the given object at the end of the list.

The function ```add(T item, int index)``` adds an element to a specific position in the list.

The list's ```remove(T item)``` function deletes the initial instance of the given element.

The function ```remove``` eliminates the item at the given index within the list.

The method ```clear()``` deletes all entries from the list.

The method ```get``` retrieves the item located at the designated index in the list.

The method ```indexOf(Object o)``` retrieves the index of the first instance of the specified item in the list. If the item cannot be found, the method returns a value of ```-1```.

The ```lastIndexOf(Object o)``` method retrieves the index of the final instance of the specified item in the list. It will return -1 if the item is not present.

The function ```sort()``` arranges the items into ascending order within the list.


Usage:

``` java
MyLinkedList<String> list = new MyLinkedList<>();
list.add("foo");
list.add("bar");
list.add("baz");
list.remove("bar");
System.out.println(list.get(1)); // Output: baz
System.out.println(list.size()); 
```



