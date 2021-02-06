package edu.escuelaing.AREP.app;
import java.io.*;
public class Node<N> {

    public N value = null;
    public Node next = null;
    public Double data;

    public Node(N e){
        this.value = e;
    }
    public N getTurn(){
        return value;
    }
    public void setNext(Node n){
        this.next=n;
    }
    public Node getNext(){
        return next;
    }
    public void setT(N nuevo){
        this.value=nuevo ;
    }



}