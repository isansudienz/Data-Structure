package com.mycompany.practicum8;

class Node {

    private int data;
    public Node(int key) {
        data = key;
    }
    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        data = id;
    }
}

public class HeapApp {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public HeapApp(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {

        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    public Node remove() {

        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {

        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
           int leftChild = 2 * index + 1;
           int rightChild = leftChild + 1;
           if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
               largerChild = rightChild;
           } else {
               largerChild = leftChild;
           }

           if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

           heapArray[index] = heapArray[largerChild];
           index = largerChild;

        }

        heapArray[index] = top;

    }

    public void displayHeap() {

        System.out.println("Heap Array: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.println("--");
            }
        }

        System.out.println("");
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());

            if (++j == currentSize) {
                break;
            } if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }

        System.out.println("\n" + dots + dots);
    }

    public void displayArray() {
        for (int j = 0; j < maxSize; j++) {
            System.out.print(heapArray[j].getKey() + " ");
        
        System.out.println("");
        }
    }
    
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }

        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }
    
    public static void main(String[] args) {
        HeapApp theHeap = new HeapApp(35);
        
        // Menambahkan 12 item
        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);
        theHeap.insert(40);
        theHeap.insert(85);
        theHeap.insert(95);
        // Menampilkan heap
        Node removed = theHeap.remove();
        System.out.println("Node yang dihapus: " + removed.getKey());
        theHeap.change(5, 110);
        theHeap.displayHeap();
        
    }
} 
