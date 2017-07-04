package com.roundforest.services;
import java.util.*;

/**
 * Created by UA C on 04.07.2017.
 */
public class Dictionary {
    private Node root = new Node(null);
    private TreeSet<Node> nodeSet = new TreeSet<Node>();
     private ArrayList <String> resultArray = new ArrayList<String>();
    private static final int RES_ARRAY_CAPACITY = 1000;


    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (char ch : chars) {
            current.addNextChar(ch);
            current = current.getNextWithChar(ch);
        }
        int count = current.increaseWordCount();
        current.addNextChar('\0');

         if(nodeSet.size()>1000){
             nodeSet.remove(nodeSet.first());
            nodeSet.add(current);
         }else {
             nodeSet.add(current);
         }
    }

    public List getMostCommonWord() {
        for(Node n : nodeSet){
        resultArray.add(printWordByLastNode(n));}
        return resultArray;
    }

    public String printWordByLastNode(Node n) {
        StringBuilder builder = new StringBuilder();
        while (n.getValue() != null) {
            builder.append(n.getValue());
            n = n.getParrent();
        }
        return builder.reverse().toString();
    }

}
