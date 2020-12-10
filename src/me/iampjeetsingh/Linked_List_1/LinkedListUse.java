package me.iampjeetsingh.Linked_List_1;

import java.util.Scanner;

public class LinkedListUse {
    public static Node<Integer> createLinkedList(){
        Node<Integer>
                n1 = new Node<>(10),
                n2 = new Node<>(20),
                n3 = new Node<>(30),
                n4 = new Node<>(40)
        ;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void print(Node<Integer> head){
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void increment(Node<Integer> head){
        while (head!=null){
            head.data++;
            head = head.next;
        }
    }

    public static Node<Integer> takeInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null, prev = null;
        while (data!=-1){
            Node<Integer> node = new Node<>(data);
            if(head==null){
                head = node;
            }else {
                prev.next = node;
            }
            prev = node;
            data = s.nextInt();
        }
        return head;
    }

    public static Node<Integer> insert(Node<Integer> head, int pos, int data){
        if (pos==0){
            Node<Integer> node = new Node<>(data);
            node.next = head;
            head = node;
            return head;
        }
        Node<Integer> prev = head;
        while (pos!=1 && prev!=null){
            prev = prev.next;
            pos--;
        }
        if(prev!=null){
            Node<Integer> node = new Node<>(data);
            node.next = prev.next;
            prev.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
    }
}
