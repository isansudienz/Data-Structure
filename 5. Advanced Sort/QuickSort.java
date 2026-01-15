/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicum6.Pendahuluan;

/**
 *
 * @author Admin
 */
public class QuickSort {
    private int arr[]; private int nElemen;
    public QuickSort(int size) { 
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
    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public void QuickSort() {
    recQuickSort(0, nElemen - 1);
    }

    public void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return;
        } else {
            int pivot = arr[batasKanan];
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    public int partitionIt(int batasKiri, int batasKanan, int pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;
        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri] < pivot) {
            }
            while (indexKanan > batasKiri && arr[--indexKanan] > pivot) {
            }
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        swap(indexKiri, batasKanan);
        return indexKiri;
    }
    public static void main(String[] args) {
        QuickSort arr = new QuickSort(10);
        arr.insert(64);
        arr.insert(34);
        arr.insert(25);
        arr.insert(12);
        arr.insert(22);
        arr.insert(11);
        arr.insert(90);
        arr.insert(18);

        System.out.println("Array awal:");
        arr.display();
        System.out.println("Proses pengurutan:");
        arr.QuickSort();
        System.out.println("Array setelah diurutkan:");
        arr.display();
    }
}
    