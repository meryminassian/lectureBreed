package com.company;

public class Breed {
    Breed left, right;
    long id;
    String name;
    long height;

    public Breed(long id, String name, long height){
        this.id=id;
        this.name= name;
        this.height= height;
    }

    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if (!(o instanceof Breed)){
            return false;
        }
        Breed b= (Breed) o;
        return this.id== b.id && this.name ==b.name && this.height ==b.height;
    }

}
