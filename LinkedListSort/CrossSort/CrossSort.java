package LinkedListSort.CrossSort;
import java.util.Random;

@SuppressWarnings("serial")

class Node extends Random {
    int num;
    public Node next;

    Node() {
        this.num = nextInt(5) +1;
        this.next = null;
    }
}

class List {
    private Node first;

    public List() { first = new Node(); }

    public List(int n) {
        first = new Node();
        first.num = n;
    }

    public List(List other) {
        this.first = other.first;
    }

    public List addlist(List other) {
        if ( first.next == null) first.next = other.first;
        else {
            Node temp = first;
            while(temp.next != null) temp = temp.next;
            temp.next = other.first;
        }
        return this;
    }

    public void addNode(int n) {
        Node nextNode = new Node();
        nextNode.num = n;

        if (first.next == null) first.next = nextNode;
        else {
            Node temp = first;
            while (temp.next != null) temp = temp.next;
            temp.next = nextNode;
        }
    }

    public void showList() {
        Node temp = this.first;
        int i = 1;
        while ( temp != null) {
            System.out.println("Node " + i + ": " + temp.num);
            temp = temp.next;
            i++;
        }
    }

    public List mergeList(List other) {

        Node result = new Node();

        Node temp = result;
        Node temp1 = this.first;
        Node temp2 = other.first;

        while(true) {
        temp.next = temp1;
        temp1 = temp1.next;
        temp = temp.next;

        temp.next = temp2;
        temp2 = temp2.next;
        temp = temp.next;

        if(temp.next == null) break;
        }

        result = result.next;
        this.first = result;

        return this;
    }

}

public class CrossSort {
    public static void main(String[] args) {
        List l1 = new List(1);
        l1.addNode(2);
        l1.addNode(3);
        l1.addNode(4);
        l1.addNode(5);
        l1.showList();

        System.out.println();

        List l2 = new List(l1);
        l2.showList();
        System.out.println();

        List l3 = new List(6);
        l3.addNode(7);
        l3.addNode(8);
        l3.addNode(9);
        l3.addNode(10);
        l1.addlist(l3).showList();
        System.out.println();

        l1.mergeList(l3).showList();
    }
}