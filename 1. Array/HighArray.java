
class HighArray {
    private final int[] arr;
    private int nElemen;

    public HighArray(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public boolean find(int searchKey) {
        for (int i = 0; i < nElemen; i++) {
            if (arr[i] == searchKey) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int value) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (value == arr[i]) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen - 1; j++) {
                arr[j] = arr[j + 1];
            }
            nElemen--;
            return true;
        }
    }

    // Method untuk menampilkan array
    public void display() {
        System.out.print("Array: [");
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i]);
            if (i < nElemen - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // BUBBLE SORT
    public void BubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i] > arr[i + 1]) {// ganti < untuk descending
                    swap(i, i + 1);

                }
                display();
            }
        }
    }

    // Method untuk menukar elemen
    public void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    // SELECTION SORT
    public void SelectionSort() {
        int awal, i, min;
        for (awal = 0; awal < nElemen - 1; awal++) {
            min = awal;
            for (i = awal + 1; i < nElemen; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            swap(awal, min);
            display();
        }
    }

    // INSERTION SORT
    public void InsertionSort() {
        int i, curIn;
        for (curIn = 1; curIn < nElemen; curIn++) {
            int temp = arr[curIn];
            i = curIn;
            while (i > 0 && arr[i - 1] >= temp) {
                arr[i] = arr[i - 1];
                display();
                i--;
            }
            arr[i] = temp;
        }
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        // HighArray arr;
        // arr = new HighArray(100);

        // arr.insert(70);
        // arr.insert(80);
        // arr.insert(75);
        // arr.insert(55);
        // arr.insert(25);
        // arr.insert(85);
        // arr.insert(30);
        // arr.insert(00);
        // arr.insert(90);
        // arr.insert(40);
        // System.out.println("item awal");
        // arr.display();

        // int searchKey = 25;
        // if (arr.find(searchKey)) {
        // System.out.println("ditemukan " + searchKey);
        // }else{
        // System.out.println("tidak ditemukan " + searchKey);
        // }
        // arr.delete(80);
        // arr.delete(00);
        // arr.delete(90);
        // System.out.println("setelah di delete");

        // arr.display();
        // Bubble Sort
        HighArray bubbleArr = new HighArray(100);
        bubbleArr.insert(70);
        bubbleArr.insert(80);
        bubbleArr.insert(75);
        bubbleArr.insert(55);
        bubbleArr.insert(25);
        bubbleArr.insert(85);
        System.out.println("data sebelum di sorting");
        bubbleArr.display();
        System.out.println("Bubble Sort:");
        bubbleArr.BubbleSort();
        bubbleArr.display();

        // Selection Sort
        HighArray selectionArr = new HighArray(100);
        selectionArr.insert(70);
        selectionArr.insert(80);
        selectionArr.insert(75);
        selectionArr.insert(55);
        selectionArr.insert(25);
        selectionArr.insert(85);
        selectionArr.display();
        System.out.println("Selection Sort:");
        selectionArr.SelectionSort();

        // Insertion Sort
        HighArray insertionArr = new HighArray(100);
        insertionArr.insert(70);
        insertionArr.insert(80);
        insertionArr.insert(75);
        insertionArr.insert(55);
        insertionArr.insert(25);
        insertionArr.insert(85);
        insertionArr.display();
        System.out.println("Insertion Sort:");
        insertionArr.InsertionSort();
        insertionArr.display();
    }
}