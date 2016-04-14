/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

/**
 * Burada kullanilan interface in amaci arraylist, vector,linkedlist
 * gibi veri yapılarıyla olusturulacak olan classlardaki fonksiyonlarin 
 * asagidaki fonksiyonlari kullanmaya zorunlu kilmaya calismak bir araya toplamaktir
 * @author Mercan
 * @param <E> 
 */
public interface MyPriorityQueue<E> {
    
    /**
     * Queue nun eleman sayisini return eder
     * @return eleman sayisini return eder
     */
    public int size();
    
    /**
     * Queue nun bos olup olmadigini kontrol eder
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * prioritysine bagli olarak bos olup olmadigini kontrol eder
     * @param newEntry
     * @return boolean return eder
     */
    public boolean enqueue(E newEntry);
    
    /**
     * Queue dan eleman cikarir fakat daha sonra oranin kontrolunu prioritysine
     * bagli olarak kontrol eder
     * @return silinen elemani return eder
     */
    public E dequeue();
    
}
