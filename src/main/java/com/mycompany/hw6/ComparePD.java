/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

import java.util.Comparator;

/**
 *Comparator bir interface oldugu icin direk object olusturmak mumkun degildi
 * bundan dolayi onu implement eden ve herhangi bir fonksiyonunu(ayni zamanda 
 * turemis classlarda da kullanilan compare methodu) override eden bir class 
 * yapisi olusturulmustur
 * @author Mercan
 */

public class ComparePD implements Comparator<Integer> {
    /**
     * İki tane integer deger alarak onlarin karsilastirilmasi yapilmistir
     * variable larin integer olarak secilmesinin sebebi yapinin integer
     * tipine uyumuyla iliskilidir
     * @param left soldaki Integer deger
     * @param right sagdaki Integer deger
     * @return karsilastırma sonucu integer olarak return edilir
     */
    public int compare(Integer left,Integer right)
    {
        int returnValue;
        if(left<right)
        {
            returnValue=-1;
        }
        else if(left>right)
        {
            returnValue=1;
        }
        else
        {
            returnValue=0;
        }
        return returnValue;
    }
}