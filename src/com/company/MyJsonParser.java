package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import com.company.MyBreedSTree;

public class MyJsonParser {

    public static void main(String[] args) throws IOException, ParseException{
	    //parsing file "JSONExample.jso"
        Object obj= new JSONParser().parse (new FileReader("C:\\Users\\minas\\Desktop\\dogs.json"));

        //typecasting obj to JSONObject
        JSONArray breeds= (JSONArray) obj;


        //iterating over the breeds
        Iterator it=breeds.iterator();
        //making empty tree
        MyBreedSTree tree = new MyBreedSTree();
        while(it.hasNext()){
            JSONObject breed= (JSONObject)it.next();
            long id= (long) breed.get("id");
            String name = (String) breed.get("name");
            String heightRange = (String) ((JSONObject) breed.get("height")).get("metric");
            String[] heights= heightRange.split("-");
            //System.out.println(name + " : " + heights[0]);

            //will print result before ordering it by id in myBreedSTree
            //System.out.println(name + " : " + id);

            Breed b= new Breed(id, name, Long.parseLong(heights[0].trim()));
            tree.addNode(b);
        }
        tree.printInorder();
    }
}
