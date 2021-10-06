package co.tushar.linkedlist;
import java.io.*;
import java.util.*;

public class extra {

  private Node head;
  private Node tail;
  private int size=0;


  class Node{
      private int data;
      private Node next;
      Node(int data){

    this.data=data;
      }
  }

  public void insertFirst(int value){
      Node nd=new Node(value);
      nd.next=head;
      head=nd;
      size++;
      if(tail==null){

    tail=head;
      }
  }
  public void deleteFirst() {
        int value=head.data;
        head=head.next;
        size--;
       
    }
    
    public void deleteLast() {
       
        if(size<2) {
             deleteFirst();
             return;
        }
        
        int value=tail.data;
        Node temp=head;
        while(temp.next!=tail) {
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        size--;
       
    }

  public void insertLast(int value){
      if(size==0){
          insertFirst(value);
          return;
      }
      Node nd=new Node(value);
      tail.next=nd;
      tail=nd;
      size++;
      
  }
  public void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void insertBetween(int value,int index) {
        if(index==0) {
            insertFirst(value);
            return;
        }
        if(index==size) {
            insertLast(value);
            return;
        }
       
        Node nd=new Node(value);
        Node temp=get(index-1);
        nd.next=temp.next;
        temp.next=nd;
        size++;
    }

    private Node get(int index) {
       
        Node temp=head;
        for(int i=0;i<index;i++) {
            temp=temp.next;
        }
        return temp;
    }

    public void deleteBetween(int index){
        if(index==0) {
             deleteFirst();
             return;
        }
        if(index==size-1) {
             deleteLast();
             return;
        }
        
        Node temp=get(index-1);
        int value=temp.next.data;
        temp.next=temp.next.next;
        size--;
        
        
    }
    public static void main(String[] args) {
        extra list=new extra();
        System.out.println("_-");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int v=sc.nextInt();
            list.insertLast(v);
        }
        int q=sc.nextInt();
        
        for(int i=1;i<=q;i++){
            
           String str=sc.next();
           if(str.equals("Insert")){
                int a=sc.nextInt();
                 int b=sc.nextInt();
               list.insertBetween(b,a);
                
           }else{
               int c1=sc.nextInt();
               list.deleteBetween(c1);
           }
            
        }

        list.display();
    
    }
}