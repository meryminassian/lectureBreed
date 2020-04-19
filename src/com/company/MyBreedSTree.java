package com.company;
import com.company.Breed;

public class MyBreedSTree {
    Breed root;
    public MyBreedSTree(){
        root= null;
    }
    public MyBreedSTree(Breed r){
        root=r;
    }
    public void addNode(Breed b){
        root = addNodeRec(root, b);
            }
    //adding b to the root by rec func.
    //also going to sort by id
    private Breed addNodeRec(Breed root, Breed b){
        if (null == root){
            return  b;
        }
        if(b.height> root.height){
            root.right = addNodeRec(root.right, b);
        } else if(b.height < root.height){
            root.left = addNodeRec(root.left, b);
        }
        return root;
    }

    public void printInorder(){
        printInorderRec(root);
    }
    private void printInorderRec(Breed r){
        if(null == r){
            return;
        }
        printInorderRec(r.left);
        System.out.println(r.name + " : " + r.id + " : " + r.height);
        printInorderRec(r.right);
    }
}
