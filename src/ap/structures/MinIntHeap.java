package ap.structures;

import java.util.Arrays;

public class MinIntHeap {
    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];

    int getLeftChildIndex(int parentIndex) {  //get left child index of parent index passed in.
        return 2 * parentIndex + 1;
    }

    int getRightChildIndex(int parentIndex) { //get right child of parent index passed in.
        return 2 * parentIndex + 2;
    }

    int getParentIndex(int childIndex) { //get parent index of the child index passed in.
        return (childIndex - 1) / 2;
    }

    boolean hasLeftChild(int index) {   //return true if index has left child.
        return getLeftChildIndex(index) < size;
    }

    boolean hasRightChild(int index) {  //return true if index has right child.
        return getRightChildIndex(index) < size;
    }

    boolean hasParent(int index) { //return true if index has parent.
        return getParentIndex(index) >= 0;
    }

    int leftChild(int index) { //retuns left child element.
        return items[getLeftChildIndex(index)];
    }

    int rightChild(int index) { //returns right child element.
        return items[getRightChildIndex(index)];
    }

    int parent(int index) {   //return parent element.
        return items[getParentIndex(index)];
    }

    void swap(int indexOne,int indexTwo) {  //swaps values.
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    void ensureExtraCapacity() { //resizes array.
        if (size == capacity) {
            items = Arrays.copyOf(items,capacity*2);
            capacity *= 2;
        }
    }

    public int peek() {  //gets the topmost element.
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() { //gets the topmost element and removes it from the array.
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }



}
