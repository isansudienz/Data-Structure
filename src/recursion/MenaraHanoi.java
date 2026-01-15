/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicum5;

/**
 *
 * @author Admin
 */
public class MenaraHanoi {
    public static void doMenara(int n, char sumber, char bantu, char tujuan) {
        if (n == 1) { 
            System.out.println("Pindahkan cakram 1 dari " + sumber + " ke " + tujuan);
            return;
        }
        doMenara(n - 1, sumber, tujuan, bantu);
        System.out.println("Pindahkan cakram " + n + " dari " + sumber + " ke " + tujuan);
        doMenara(n - 1, bantu, sumber, tujuan);
    }

    public static void main(String[] args) {
        int jumlahCakram = 3; 
        System.out.println("Langkah-langkah Menara Hanoi untuk " + jumlahCakram + " cakram:");
        doMenara(jumlahCakram, 'A', 'B', 'C');
    }
}