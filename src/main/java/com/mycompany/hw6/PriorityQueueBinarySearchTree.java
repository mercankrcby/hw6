/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

import java.util.Comparator;
/**
 * Bu class myPriorityqueue adli interfaceden turemis ve oradaki methodlari 
 * BinarySearchTree kullarak override etmistir
 * @author Mercan
 */
public class PriorityQueueBinarySearchTree<E extends Comparable<E>> implements MyPriorityQueue<E> {
   
    public BinarySearchTree<E> bSearchObj;
    Comparator<E> comparator = null;
    /**
     * constructor
     * @param comp 
     */
    public PriorityQueueBinarySearchTree(Comparator<E> comp)
    {
        bSearchObj=new BinarySearchTree<>();
        comparator=comp;
    }
    /**
     * queue nun size ini return eder-----Binary tree de tum fonksiyonlara
     * ek olarak size fonksiyonu yazip onu cagirdim-----------------------
     * @return 
     */
    public int size()
    {
        return bSearchObj.size();
    }
    /**
     * queue nun bos olup olmadigini kontrol eder
     * @return 
     */
    public boolean isEmpty()
    {
        return bSearchObj.root==null;
    }
    /**
     * verilen elemani ekler 
     * @param item
     * @return 
     */
    public boolean enqueue(E item)
    {
        return bSearchObj.add(item);
    }
    /**
     * eleman siler
     * @return 
     */
    public E dequeue()
    {
        return bSearchObj.delete(bSearchObj.root.data);
    }
    
}
