package Linked_List;

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

    public static void printR(Node<Integer> head){
        if(head==null)
            return;
        System.out.print(head.data+" ");
        printR(head.next);
    }

    public static Node<Integer> insertR(Node<Integer> head, int value, int position){
        if(position==0){
            Node<Integer> node = new Node<>(value);
            node.next = head;
            return node;
        }
        if(head==null)
            return null;
        head.next = insertR(head.next, value, position-1);
        return head;
    }

    public static Node<Integer> reverseLinkedListRec(Node<Integer> head) {
        if(head==null || head.next==null)
            return head;
        Node<Integer> revHead = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }

    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> head = null, tail = null;
        if(head1==null || head2==null)
            return head1==null ? head2 : head1;
        if(head1.data<head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }else {
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while (head1!=null && head2!=null){
            if(head1.data<head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        tail.next = head1!=null ? head1 : head2;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = takeInput();
        Node<Integer> head2 = takeInput();
        printR(merge(head1,head2));
    }
}
