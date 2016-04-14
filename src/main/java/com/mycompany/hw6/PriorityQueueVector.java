/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

import java.util.Comparator;
import java.util.Vector;

/**
 * Bu class myPriorityqueue adli interfaceden turemis ve oradaki methodlari 
 * vector kullarak override etmistir
 * @author Mercan
 */
public class PriorityQueueVector<E> implements MyPriorityQueue<E> {
    public Vector<E> queueVector;
    Comparator<E> comparator = null;
    /**
     * constructor
     * @param comp 
     */
    public PriorityQueueVector(Comparator<E> comp)
    {
        queueVector = new Vector<E>();
        comparator=comp;
    }
    /** 
     * vektorun size ini return eder
     * @return 
     */
    public int size()
    {
        return queueVector.size();
    }
    /**
     * vektor bos mu dolu mu diye kontrol eder
     * @return 
     */
    public boolean isEmpty()
    {
        return queueVector.size()==0;
    }
    /**
     * prioritysine bakarak gelen item i ekler
     * @param item
     * @return 
     */
    public boolean enqueue(E item)
    {
        queueVector.add(item);
        int child=queueVector.size()-1;
        int parent=(child-1)/2;
        while( parent>=0 && compare(queueVector.get(parent),queueVector.get(child))>0)
        {
            swap(parent,child);
            child=parent;
            parent=(child-1)/2;
        }
        return true;
    }
    /**
     * priotiysine bakarak uygun yerdeki elemani siler
     * @return silinen eleman return edilir
     */
    public E dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        E result=queueVector.get(0);
        if(queueVector.size()==1)
        {
            queueVector.remove(0);
            return result;
        }
        queueVector.set(0, queueVector.remove(queueVector.size()-1));
        int parent=0;
        while(true)
        {
            int leftChild=2*parent +1;
            if(leftChild>=queueVector.size())
                break;
            int rightChild=leftChild +1 ;
            int minChild=leftChild;
            if(rightChild<queueVector.size() && compare(queueVector.get(leftChild),queueVector.get(rightChild))>0)
            {
                minChild=rightChild;
            }
            if(compare(queueVector.get(parent),queueVector.get(minChild))>0)
            {
                swap(parent,minChild);
                parent=minChild;
            }
            else
            {
                break;
            }
        }
        return result;
    }
    /**
     * gelen iki elemanin vektordeki yerlerini degistirir
     * @param parent
     * @param minChild 
     */
    public void swap(int parent,int minChild)
    {
        E temp;
        temp=queueVector.get(parent);
        queueVector.set(parent, queueVector.get(minChild));
        queueVector.set(minChild, temp);
    }
    /** 
     * gelen iki degeri karsilastirir buna bagli olarak -1,0,1 return eder
     * @param left
     * @param right
     * @return 
     */
    private int compare(E left,E right)
    {
        if(comparator !=null)
        {
            return comparator.compare(left, right);
        }
        else
        {
            return ((Comparable<E>) left).compareTo(right);
        }
    }
    
}