package edu.escuelaing.AREP.app;
import edu.escuelaing.AREP.app.Node;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedListImplementation<E> implements Iterable<E>, Serializable {
    Node<E> first=null;
    Node<E> end=null;
    int size=0;

    public int size() {
        Node nero = first;
        int len = 0;
        while (nero != null ) {
            nero = nero.getNext();
            len++;
        }
        return len;
    }
    @Override
    public Iterator<E> iterator(){
        Iterator<E> iterator;
        iterator = new Iterator<E>() {
            Node now=first;
            @Override
            public boolean hasNext() {
                boolean exit1=false;
                if(null!=now){
                    exit1=true;
                }
                return exit1;
            }
            @Override
            public E next(){
                E var =(E)now.getTurn();
                if(now.equals(end)){
                    now=null;
                }else{
                    now=now.getNext();
                }
                return var;
            }
        };
        return iterator;
    }
    public void insert (int data){
        Node node = new Node(data);
        node.data = data;

        if (first==null){
            first=node;
            node.setNext(null);
            first=node;
        }
        else{
            Node n = first;
            while(n.next!=null){
                n=n.next;
            }
            n.next = node;

        }
    }
    public Node right (Node data) throws IndexOutOfBoundsException{
        return data;
    }
    public void show() throws IndexOutOfBoundsException{
        Node node = first;
        while (node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
    public void insertAtStart(int data) throws IndexOutOfBoundsException{
        Node node = new Node(data);
        node.data = data;
        node.next = null;
        node.next = first;
        first = node;
    }
    public  LinkedListImplementation remove (int value, LinkedListImplementation list) throws IndexOutOfBoundsException{
        Node n = first;
        Node n1 = null;
        if ((n != null) && n.data != value){
            list.first= n.next;
            return list;
        }
        while (n !=null && n.data!= value){
            n1 = n;
            n = n.next;
        }
        if (n!=null){
            n1.next = n.next;
        }
        if(n==null){
        }
        return list;
    }
    public boolean remove(Object o) {
        Node node = first;
        Node previous=null;
        E informacion=null;
        boolean flag=false;
        int tamano = size();
        while (tamano != size() && node != null){
            informacion = (E) node.getTurn();
            if(informacion.equals(o)){
                flag=true;
                if(previous!=null){
                    previous.setNext(node.getNext());
                    first=previous;
                }else{
                    first=first.getNext();
                }
            }else {
                tamano--;
                previous = node;
                node = node.getNext();
            }
        }
        return flag;
    }

}
