package com.mycompany.practicum8;

// Class Node - objek dari item
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

// Class Heap - untuk HeapSort
class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    // Constructor
    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    // Method insertAt - menambahkan item pada indeks tertentu
    public void insertAt(int index, int value) {
        Node newNode = new Node(value);
        heapArray[index] = newNode;
        currentSize++;
    }

    // Method trickleDown
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            // Pilih child yang lebih besar
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            // Jika sudah pada posisi yang tepat, break
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            // Pindahkan larger child ke atas
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }

    // Method displayArray - menampilkan isi array
    public void displayArray() {
        System.out.print("Array: ");
        for (int j = 0; j < maxSize; j++) {
            if (heapArray[j] != null) {
                System.out.print(heapArray[j].getKey() + " ");
            }
        }
        System.out.println();
    }

    // Method HeapSort - algoritma sorting
    public void heapSort() {
        System.out.println("Membentuk Heap MAX  dari array ");

        // Langkah 1: Heapify - trickle down dari (N/2-1) hingga 0
        int startIndex = (currentSize / 2) - 1;
        System.out.println("Mulai trickle down dari indeks " + startIndex + " hingga 0\n");

        for (int i = startIndex; i >= 0; i--) {
            System.out.println("-> Trickle down pada indeks " + i + " (nilai: " + heapArray[i].getKey() + ")");
            trickleDown(i);
            displayArray();
        }

        System.out.println("Removal & Penyimpanan nilai maksimum ke posisi terakhir array");
        System.out.println("Remove root (nilai max) dan simpan di posisi terakhir\n");

        // Langkah 2: Remove heap dan simpan dari belakang
        int savedSize = currentSize;

        for (int i = currentSize - 1; i > 0; i--) {
            // Simpan root (nilai maksimum)
            Node max = heapArray[0];

            // Pindahkan last node ke root
            heapArray[0] = heapArray[currentSize - 1];

            // Simpan max di posisi terakhir
            heapArray[currentSize - 1] = max;

            // Kurangi currentSize
            currentSize--;

            System.out.println("-> Simpan " + max.getKey() + " ke indeks " + i);

            // Trickle down untuk restore heap property
            if (currentSize > 0) {
                trickleDown(0);
            }

            displayArray();
        }

        // Restore currentSize
        currentSize = savedSize;
    }
}

// Class HeapSortApp - berisi method main
public class HeapSortApp {
    public static void main(String[] args) {
        int size = 15;
        Heap theHeap = new Heap(size);

        // Menambahkan data random ke heap array
        System.out.println("DATA RANDOM:");
        System.out.println("---------------");
        for (int i = 0; i < size; i++) {
            int randomValue = (int) (Math.random() * 100) + 1;
            theHeap.insertAt(i, randomValue);
            System.out.println("Indeks " + i + ": " + randomValue);
        }

        // Menampilkan array sebelum diurutkan
        System.out.println("ARRAY SEBELUM DIURUTKAN:");
        theHeap.displayArray();

        // Menjalankan HeapSort
        theHeap.heapSort();

        // Menampilkan array setelah diurutkan
        System.out.println("ARRAY SETELAH DIURUTKAN (ASCENDING):");
        theHeap.displayArray();

        System.out.println("\nSORTING SELESAI!");
    }
}