package com.roundforest.services;



import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by UA C on 04.07.2017.
 */
public class Dictionary {
    private Node root = new Node(null);
    private TreeMap<Integer,Node> resArray = new TreeMap<Integer,Node>();
    private static final int RES_ARRAY_CAPACITY = 1000;


    public void addWord(String word){
        char[] chars = word.toCharArray();
        Node current = root;
        for (char ch : chars){
            current.addNextChar(ch);
            current = current.getNextWithChar(ch);
        }
        int count =  current.increaseWordCount();
        current.addNextChar('\0');

        System.out.println(count);
        if(resArray.size()<100){
        resArray.put(count,current);
        }else {
            int comp = current.getWordCounter()-resArray.firstKey();
            if(comp>1){
            resArray.remove(resArray.firstKey());
            resArray.put(count,current);}
        }

    }

    public void printTop(){
        System.out.println("******TOP**********");
        for(Map.Entry<Integer, Node> e : resArray.entrySet()){
            System.out.println(e.getKey()  + " " +printWordByLastNode(e.getValue()));
        }
    }
    public String printWordByLastNode(Node n){
        StringBuilder builder = new StringBuilder();
        while (n.getValue()!=null){
            builder.append(n.getValue());
            n=n.getParrent();
        }
        return builder.reverse().toString();
    }
   /* public void getTopThousand( ) {
            for(int i =0;i<2;++i) {
                Node current = root;
                ArrayList<Character> arr = new ArrayList();
                StringBuilder builder = new StringBuilder();
                if(current.getValue()==null){
                    current=current.getMaxInd();
                }
                while (!current.getValue().equals("\0")) {
                    if (current.getWordCounter() != 0) {
                        current.setWordCounter(0);
                        if(current.getValue()!=null){
                        builder.append(current.getValue());}
                        current = current.getMaxInd();
                        break;
                    }
                    if(current.getValue()!=null){
                    builder.append(current.getValue());}
                    current = current.getMaxInd();
                }
                String str = builder.toString();
                System.out.println(str);
                //resArray.add(str);
            }

        }*/
    }
