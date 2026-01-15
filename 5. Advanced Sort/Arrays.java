package com.mycompany.practicum6.Pendahuluan;

public class Arrays {
    private int arr[]; private int nElemen;
    public Arrays(int size) { 
        arr = new int[size]; nElemen = 0;
    }
    public void insert(int value) { 
        arr[nElemen] = value; nElemen++;
    }
    public void display() {
        for (int i = 0; i < nElemen; i++) { 
            System.out.print(arr[i] + " ");
        }
    System.out.println("");
    }
    public void ShellSort () {
    int in, out, temp;
    int h = 1;
    while (h <= nElemen/3) {
        h = 3*h + 1;// h = 1, 4, 13, 40, ...
    }
        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;
                while (in > h - 1 && arr[in - h] >= temp) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
            arr[in] = temp;
            display();
            }
            h = (h - 1) / 3;// Kurangi interval sesuai Knuth
        }
    }
    public static void main(String[] args) {
        Arrays array = new Arrays(10);
        array.insert(64);
        array.insert(34);
        array.insert(25);
        array.insert(12);
        array.insert(22);
        array.insert(11);
        array.insert(90);
        array.insert(45);
        array.insert(33);
        array.insert(8);
        System.out.println("Data sebelum diurutkan:\n");
        array.display();
        System.out.println("Data setelah Shellsort:");
        array.ShellSort();
        
    }
}
