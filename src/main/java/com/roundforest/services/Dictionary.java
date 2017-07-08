package com.roundforest.services;
import java.util.*;

/**
 * Created by UA C on 04.07.2017.
 */
public class Dictionary{
    private Node root = new Node(null);
    private ArrayList<Node> nodeSet = new ArrayList<Node>();
    private ArrayList <String> resultArray = new ArrayList<String>();


    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (char ch : chars) {
            current.addNextChar(ch);
            current = current.getNextWithChar(ch);
        }
        current.increaseWordCount();
        current.addNextChar('\0');

         if(!nodeSet.contains(current)){
            nodeSet.add(current);
         }
    }

    public List getMostCommonWord() {
        nodeSet.sort(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o2.getWordCounter()-o1.getWordCounter();
            }
        });

        for(int i=0;i<1000;++i){
        resultArray.add(printWordByLastNode(nodeSet.get(i)));}
        return resultArray;
    }

    public String printWordByLastNode(Node n) {
        int c = n.getWordCounter();
        StringBuilder builder = new StringBuilder();
        while (n.getValue() != null) {
            builder.append(n.getValue());
            n = n.getParrent();
        }
        return builder.reverse().toString();
    }


}
