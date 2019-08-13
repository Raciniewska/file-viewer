/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_._platformy;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author Basia
 */
public class Java__platformy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "C:\\Users\\Basia\\Documents\\NetBeansProjects\\.";//(new File(".")).getAbsolutePath();//"C:\\Users\\Basia\\Desktop\\.";
        //DiskObjectNaturalComparator cmp = null;
        Comparator cmp=null;
        boolean rec = true;
        for (String arg : args) {
            if(arg.equals("--notRec")){
                rec=false;
            }
           else if (arg.equals("--dictSorted")) {//najpierw katalogi potem pliki
                cmp = new DiskObjectNaturalComparator();
            }
            else if (arg.equals("--sortedByModification")) {
                cmp = new Java_date_modif_comparator();
            }
            else if (arg.equals("--sortedByNameLength")) {
                cmp = new name_length_comparator();
            } 
            else if (arg.equals("--sortedBySize")) {
                cmp = new sizeComparator();
            } 
            else if (arg.equals("--sortedAlphabetically")) {
                cmp = new alfabet_comparator();
            } 
            else {path = arg;}
        }
        
        try{
            File file= new File(path);
            if(!file.exists()){
                throw new Exception("Wprowadzono bledna sciezke");
            }
            DiskObject obj = new DiskObject(file,cmp,rec);
            obj.print(0);
        }catch (NullPointerException e){
            System.out.println("Nie okreslono sciezki");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
      
       
    }  
}
