/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Bu class myPriorityqueue adli interfaceden turemis ve oradaki methodlari 
 * linkedlist kullarak override etmistir
 * @author Mercan
 */
public class PriorityQueueLinkedList<E> implements MyPriorityQueue<E>{
    public LinkedList<E> queueLinkedList;
    Comparator<E> comparator = null;
    /** 
     * constructor
     * @param comp 
     */
    public PriorityQueueLinkedList(Comparator<E> comp)
    {
        queueLinkedList = new LinkedList<E>();
        comparator=comp;
    }
    /**
     * queue nun size ini return eder
     * @return 
     */
    public int size()
    {
        return queueLinkedList.size();
    }
    /**
     * queue nun bos olup olmadigini kontrol eder
     * @return 
     */
    public boolean isEmpty()
    {
        return queueLinkedList.size()==0;
    }
    /**
     * verilen elemani prioritysine bagli olarak return eder
     * @param item
     * @return 
     */
    public boolean enqueue(E item)
    {
        queueLinkedList.add(item);
        int child=queueLinkedList.size()-1;
        int parent=(child-1)/2;
        while( parent>=0 && compare(queueLinkedList.get(parent),queueLinkedList.get(child))>0)
        {
            swap(parent,child);
            child=parent;
            parent=(child-1)/2;
        }
        return true;
    }
    /**
     * verilen elemani prioritysine gore belirli duzende siler
     * @return Silinen elemani return eder
     */
    public E dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        E result=queueLinkedList.get(0);
        if(queueLinkedList.size()==1)
        {
            queueLinkedList.remove(0);
            return result;
        }
        queueLinkedList.set(0, queueLinkedList.remove(queueLinkedList.size()-1));
        int parent=0;
        while(true)
        {
            int leftChild=2*parent +1;
            if(leftChild>=queueLinkedList.size())
                break;
            int rightChild=leftChild +1 ;
            int minChild=leftChild;
            if(rightChild<queueLinkedList.size() && compare(queueLinkedList.get(leftChild),queueLinkedList.get(rightChild))>0)
            {
                minChild=rightChild;
            }
            if(compare(queueLinkedList.get(parent),queueLinkedList.get(minChild))>0)
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
     * verilen iki degeri yer degistirir
     * @param parent
     * @param minChild 
     */
    public void swap(int parent,int minChild)
    {
        E temp;
        temp=queueLinkedList.get(parent);
        queueLinkedList.set(parent, queueLinkedList.get(minChild));
        queueLinkedList.set(minChild, temp);
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
