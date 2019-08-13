/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_._platformy;

import java.util.Comparator;

/**
 *
 * @author Basia
 */
class DiskObjectNaturalComparator implements Comparator  {
    
    @Override
    public int compare(Object o1, Object o2){
        try{
            DiskObject first = (DiskObject) o1;
            DiskObject second = (DiskObject) o2;
            if(first.isDirectory && !second.isDirectory){
                return -1;
            }else if (!first.isDirectory && second.isDirectory){
                return 1;
            }else{
                return first.compareTo((second));
            } 
        }catch (ClassCastException e){
                    return 0;
                    }
    }
    }   
    
