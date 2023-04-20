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

Obtain the count of elements within the list through the use of the size() function.
This method, contains(Object o), will yield a true result if the element specified is present in the list.
The function add(T item) is used to place the given object at the end of the list.
The function add(T item, int index) adds an element to a specific position in the list.
The list's remove(T item) function deletes the initial instance of the given element.
The function "remove" eliminates the item at the given index within the list.
The method clear() deletes all entries from the list.
The method "get" retrieves the item located at the designated index in the list.
The method indexOf(Object o) retrieves the index of the first instance of the specified item in the list. If the item cannot be found, the method returns a value of -1.
The lastIndexOf(Object o) method retrieves the index of the final instance of the specified item in the list. It will return -1 if the item is not present.
The function "sort()" arranges the items into ascending order within the list.
The utilization of something.

Usage:
``` deojf ```
