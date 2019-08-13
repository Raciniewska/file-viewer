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
public class sizeComparator  implements Comparator  {
    
    @Override
    public int compare(Object o1, Object o2){
        try{
            DiskObject first = (DiskObject) o1;
            DiskObject second = (DiskObject) o2;
            long a = first.getSize()-second.getSize();
            if (a<0){
                return -1;
            }
            else if (a >=0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (ClassCastException e){
                    return 0;
                    }
    }
    }   
