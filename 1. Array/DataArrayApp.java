package com.mycompany.classarray;

class Mahasiswa{
    long nim;
    String nama;
    String asal;

    Mahasiswa(long nim, String nama, String asal){
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }

    void displayMhs(){
        System.out.println("NIM: "+nim+", Nama: "+nama+", Asal: "+asal);
    }

    long getNim(){
        return nim;
    }
}

class DataArray{
    private Mahasiswa[] mhs;
    private int nElemen;

    DataArray(int max){
        mhs = new Mahasiswa[max];
        nElemen = 0; 
    }

    Mahasiswa find(long searchNim){
        int i;
        for(i = 0 ; i< nElemen; i++){
            if(mhs[i].getNim()==searchNim)
            break;
        }    
        if (i==nElemen){
            return null;
        }else{
            return mhs[i];
        }
    }
    
    void insert(long nim ,String nama,String asal){
        mhs[nElemen]=new Mahasiswa(nim, nama, asal);
        nElemen++;
    }
    
    boolean delete(long searchNim){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim()==searchNim){
                break;
            }
        }
        if (i==nElemen){
            return false;
        }else{
            for (int j = i; j < nElemen-1; j++) {
                mhs[j]=mhs[j+1];
            }
            nElemen--;
            return true;
        }
    }
    
    void displayArray(){
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
    }
    
    void bubblesort() {
        for (int batas = nElemen - 1; batas > 0; batas--) {
            for (int i = 0; i < batas; i++) {
                if (mhs[i+1].getNim()> mhs[i].getNim()){
                    swap(i, i+1);
                }
            }
        }
    }
    
    void selectionSort(){
        for (int awal = 0; awal < nElemen - 1; awal++) {
            int min = awal;
            for (int i = awal + 1; i < nElemen; i++) {
                if (mhs[i].getNim() < mhs[min].getNim()) {
                    min = i;
                }
            }
            swap(awal, min);
        }
    }
    
    void insertionSortByNim(){
        for (int curIn = 1; curIn < nElemen; curIn++) {
            Mahasiswa temp = mhs[curIn];
            int i = curIn;
            while (i > 0 && mhs[i - 1].getNim() >= temp.getNim()) {
                mhs[i] = mhs[i - 1];
                i--;
            }
            mhs[i] = temp;
        }
    }
    
    void swap (int one, int two){
    Mahasiswa temp = mhs[one];
    mhs[one] = mhs[two];
    mhs[two] = temp;
    }
}

public class DataArrayApp{
    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr = new DataArray(maxSize);
        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650260, "Arina", "Malang");
        arr.insert(16650240, "Helmi", "Madura");
        arr.insert(16650220, "Ismail", "Banyuwangi");
        arr.insert(16650280, "Dinda", "Bandung");
        arr.insert(16650250, "Rais", "Ambon");
        arr.insert(16650200, "Jundi", "Malang");
        arr.insert(16650210, "Ahmad", "Sidoarjo");
        System.out.println("DATA MAHASISWA");
        arr.displayArray();
        arr.bubblesort();
        System.out.println("after bubble sort");
        arr.displayArray();
        DataArray arra = new DataArray(maxSize);
        arra.insert(16650270, "Agung", "Madiun");
        arra.insert(16650230, "Sofi", "Semarang");
        arra.insert(16650260, "Arina", "Malang");
        arra.insert(16650240, "Helmi", "Madura");
        arra.insert(16650220, "Ismail", "Banyuwangi");
        arra.insert(16650280, "Dinda", "Bandung");
        arra.insert(16650250, "Rais", "Ambon");
        arra.insert(16650200, "Jundi", "Malang");
        arra.insert(16650210, "Ahmad", "Sidoarjo");
        arra.selectionSort();
        System.out.println("after selection sort");
        arra.displayArray();
        DataArray arry = new DataArray(maxSize);
        arry.insert(16650270, "Agung", "Madiun");
        arry.insert(16650230, "Sofi", "Semarang");
        arry.insert(16650260, "Arina", "Malang");
        arry.insert(16650240, "Helmi", "Madura");
        arry.insert(16650220, "Ismail", "Banyuwangi");
        arry.insert(16650280, "Dinda", "Bandung");
        arry.insert(16650250, "Rais", "Ambon");
        arry.insert(16650200, "Jundi", "Malang");
        arry.insert(16650210, "Ahmad", "Sidoarjo");
        arry.insertionSortByNim();
        System.out.println("after insertion sort");
        arry.displayArray();
    }
}


