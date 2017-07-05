package com.roundforest.services;

/**
 * Created by UA C on 04.07.2017.
 */
public class Node implements Comparable<Node>{
    private static final int ABC_LENGTH = 27; //Length of alphabet + '\0'
    private static final int ASCII_A = 'a';
    private Character value = null;
    private int wordCounter = 0;

    private Node[] next = new Node[Node.ABC_LENGTH];
    private Node parrent = null;

    public Node(Character value){
        this.value = value;
    }

    public void addNextChar(char ch){
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

    public Node getNextWithChar(char ch){
        return next[indexOf(ch)];
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

    public int increaseWordCount() {
        return ++wordCounter;
    }

    public int compareTo(Node o) {
        return this.getWordCounter()-o.getWordCounter();
    }
}

