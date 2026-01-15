/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicum5;

/**
 *
 * @author Admin
 */
public class recursive {
    public static void main(String[] args) {
        int base = 2;
        int exp = 10;
        long hasil = pangkat(base,exp);
        System.out.println( base + "^"+ exp + " = "+hasil);
        base = 3;
        exp = 5;
        hasil = pangkat(base,exp);
        System.out.println( base + "^ "+ exp + " = "+hasil);
        base = 3;
        exp = 16;
        hasil = pangkat(base,exp);
        System.out.println( base + "^"+ exp + " = "+hasil);
    }
    static long pangkat(int base, int exponent){
        if( exponent == 0 ){
            return 1; // Basis kasus: setiap angka pangkat 0 adalah 1
        }else if( exponent == 1 ){
            return base; // Basis kasus: setiap angka pangkat 1 adalah angka itu sendiri
        }else{
            return base * pangkat(base,exponent-1); // Langkah rekursif: x^n = x * x^(n-1)
        }
    }
    public int factorial(int n) {
        if (n == 1) {              
            return 1;
        } else {                    // Recursive case
            return n * factorial(n - 1);
        }
    }
    // 5! = 5 × 4 × 3 × 2 × 1 = 120
    public int triangle(int n) {
        if (n == 1) {               
            return 1;
        } else {                    // Recursive case
            return n + triangle(n - 1);
        }
    }
    // triangle(5) = 5+4+3+2+1 = 15
    public int fibonacci(int n) {
        if (n <= 1) {               
            return n;
        } else {                    // Recursive case
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    // fib(5) = fib(4) + fib(3) = 5
}
