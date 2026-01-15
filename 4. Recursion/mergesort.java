package com.mycompany.practicum5;
class mergesort {
    private int arr[]; private int nElemen;
    public mergesort(int size) { 
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
    public void mergeSort() {
        int[] workSpace = new int[nElemen]; 
        recMergeSort(workSpace, 0, nElemen - 1);
    }

    public void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) { 
            return;
        } else {
            int mid = (lowerBound + upperBound)/ 2; 
            recMergeSort(workSpace, lowerBound, mid); 
            recMergeSort(workSpace, mid + 1, upperBound); 
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    public void merge(int[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex; 
        int mid = highIndex - 1;
        int nItem = upperBound - lowerBound + 1;
        while (lowIndex <= mid && highIndex <= upperBound) {
            if (arr[lowIndex] < arr[highIndex]) { workSpace[j++] = arr[lowIndex++];
            } else {
                workSpace[j++] = arr[highIndex++];
            }
        }
        while (lowIndex <= mid) { 
            workSpace[j++] = arr[lowIndex++];
        }
        while (highIndex <= upperBound) { 
            workSpace[j++] = arr[highIndex++];
        }
        for (j = 0; j < nItem; j++) { 
            arr[lowerBound + j] = workSpace[j];
        }
    }
    public static void main(String[] args) {
        mergesort array = new mergesort(10);
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
        System.out.println("Data sebelum diurutkan:");
        array.display();
        array.mergeSort();
        System.out.println("Data setelah diurutkan:");
        array.display();
    }
}