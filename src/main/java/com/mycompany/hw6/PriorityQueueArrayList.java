/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Bu class kendi olusturmus oldugum priority interface inden tureyerek 
 * oradaki fonksiyonlari array list kullanarak yapmistir
 * Asagidaki implementation kitaptaki koda benzer olarak yazilmistir
 * @author Mercan
 */
public class PriorityQueueArrayList<E> implements MyPriorityQueue<E> {
    
    public ArrayList<E> queueArrayList;
    Comparator<E> comparator = null;
    /**
     * Constructor
     * @param comp disarıda olusturulmus olan comparator classina referans olarak
     * baglanmistir
     */
    public PriorityQueueArrayList(Comparator<E> comp)
    {
        queueArrayList = new ArrayList<E>();
        comparator=comp;
    }
    /**
     * queue nun size ini return eder
     * @return 
     */
    public int size()
    {
        return queueArrayList.size();
    }
    /**
     * queue nun bos olup olmadigini return eder
     * @return bos mu dolu mu
     */
    public boolean isEmpty()
    {
        return queueArrayList.size()==0;
    }
    /**
     * gelen elemani priority sine bagli olarak degerlendirerek ekler
     * @param item
     * @return 
     */
    public boolean enqueue(E item)
    {
        queueArrayList.add(item);
        int child=queueArrayList.size()-1;
        int parent=(child-1)/2;
        while( parent>=0 && compare(queueArrayList.get(parent),queueArrayList.get(child))>0)
        {
            swap(parent,child);
            child=parent;
            parent=(child-1)/2;
        }
        return true;
    }
    /**
     * prioritye bagli olarak eleman siler
     * @return silinen elemani return eder
     */
    public E dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        E result=queueArrayList.get(0);
        if(queueArrayList.size()==1)
        {
            queueArrayList.remove(0);
            return result;
        }
        queueArrayList.set(0, queueArrayList.remove(queueArrayList.size()-1));
        int parent=0;
        while(true)
        {
            int leftChild=2*parent +1;
            if(leftChild>=queueArrayList.size())
                break;
            int rightChild=leftChild +1 ;
            int minChild=leftChild;
            if(rightChild<queueArrayList.size() && compare(queueArrayList.get(leftChild),queueArrayList.get(rightChild))>0)
            {
                minChild=rightChild;
            }
            if(compare(queueArrayList.get(parent),queueArrayList.get(minChild))>0)
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
     * arraylist de elemanlarin yerini degistirir
     * @param parent
     * @param minChild 
     */
    public void swap(int parent,int minChild)
    {
        E temp;
        temp=queueArrayList.get(parent);
        queueArrayList.set(parent, queueArrayList.get(minChild));
        queueArrayList.set(minChild, temp);
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