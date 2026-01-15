/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doublylinkedlist;

/**
 *
 * @author User
 */
public class Link {
    public int Data; 
    public Link next; 
    public Link previous;   
    
    public Link(int Data) { 
        this.Data = Data;
    }
    
    public void displayLink() { 
        System.out.print(Data + " ");
    }
}
