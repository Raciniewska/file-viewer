/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_._platformy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Basia
 */
class DiskObject  implements Comparable<DiskObject> {
    TreeSet<DiskObject> children;
    protected File file;
    protected boolean isDirectory;
    protected boolean recursion;
    
    protected void print(int depth){
        SimpleDateFormat template= new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder name=new StringBuilder();
        if(depth>0){
            for(int i=0;i<depth;i++){ name.append('-');}
            name.append('-'); 
        }
        name.append(file.getName()+"   ");
        if(this.isDirectory){
            name.append(" K "+this.getSize()+" files ");
        }else{ name.append(" P " + this.getSize() + " bytes ");}
        name.append(template.format(file.lastModified()));
        System.out.println(name);
        if(this.isDirectory&&this.recursion==true){
            for(DiskObject obj : children){
                obj.print(depth+1);
            }
        }
    }
     public DiskObject(File file, Comparator cmp){
        this.recursion=false;
        this.file=file;
        this.isDirectory=file.isDirectory();
     }
    public DiskObject(File file, Comparator cmp, boolean rec){
        this.recursion=true;
        this.file=file;
        this.isDirectory=file.isDirectory();
        if(this.isDirectory){
            if(cmp!=null){
                this.children=new TreeSet<>(cmp);
            }else this.children=new TreeSet<>();
            File[] childFiles=file.listFiles();
           // childFiles[0].getPath()
            for(File f : childFiles){
               //System.out.println(f.getPath());
              if(rec==true){
               this.children.add( new DiskObject(f,cmp,rec));
              }
              else{
                  this.children.add( new DiskObject(f,cmp));
              }
               
            }
        }
    }
    public long folderSize(File directory) {
    long length = 0;
    for (File file : directory.listFiles()) {
        if (file.isFile())
            length += file.length();
        else
            length += folderSize(file);
    }
    return length;
}
    
    public long getSize(){
        if(this.file.isFile()){return this.file.length();}
        else return folderSize(this.file);
    }
    public boolean equals(DiskObject obj){
        return this.file.equals((obj.file));
    }
    public long lastModufication(){
       return this.file.lastModified();
    }
    public int nameLength(){
      
        String a=this.file.getName();
        return a.length();
    }
    public String getName(){
    return  this.file.getName();
    }
    @Override
    public int hashCode() {
        return (367 * ((int)this.getSize()) + this.file.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        else if (getClass() != obj.getClass()) return false;
        else return (this.compareTo((DiskObject) obj) == 0);
    }
    
    public int compareTo(DiskObject object) {
        if (this.getSize() < object.getSize()) {
            return -1;
        } else if (this.getSize() == object.getSize()) {
            return 0;
        } else return 1;
    }
}
