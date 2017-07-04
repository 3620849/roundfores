package com.roundforest.services;

/**
 * Created by UA C on 04.07.2017.
 */
public class Node implements Comparable<Node>{
    private static final int ABC_LENGTH = 27; //Length of alphabet + '\0'
    private static final int ASCII_A = 'a';
    private Character value = null;
    private int flag = 0;
    private int wordCounter = 0;

    private Node[] next = new Node[Node.ABC_LENGTH];
    private Node parrent = null;

    public Node(Character value){
        this.value = value;
    }

    public void addNextChar(char ch){
        ++flag;
        int index = indexOf(ch);

        if (!existsInNext(index)){
            next[index] = new Node(ch);
            next[index].setParrent(this);
        }
    }

    public int getWordCounter() {
        return wordCounter;
    }

    public void setWordCounter(int wordCounter) {
        this.wordCounter = wordCounter;
    }

    private int indexOf(char ch){
        return ch == '\0' ? (ABC_LENGTH-1) : (ch-ASCII_A);
    }
    private boolean existsInNext(int index) {
        return next[index] != null;
    }

    public int getFlag() {
        return flag;
    }

    public Node getNextWithChar(char ch){
        return next[indexOf(ch)];
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Character getValue() {
        return value;
    }

    public Node getParrent() {
        return parrent;
    }

    public void setParrent(Node parrent) {
        this.parrent = parrent;
    }

    public Node getMaxInd(){
        int ind = 0;
        int max = 0;

        for(int i = 0;i<next.length;++i){
            if(next[i]!=null){
            if(next[i].getFlag()>max){
                max=next[i].getFlag();
                ind = i ;
            }}
        }
        --flag;

        return next[ind];

    }
    public int increaseWordCount() {
        return ++wordCounter;
    }


    public int compareTo(Node o) {
        return this.getWordCounter()-o.getWordCounter();
    }
}

