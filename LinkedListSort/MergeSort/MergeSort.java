package LinkedListSort.MergeSort;

class Node {
    int num;
    Node next;

    Node() {
        num = 0;
        next = null;
    }
}

class List {
    Node first;

    public List() { first = new Node(); }

    public List(int num) {
        first = new Node();
        first.num = num;
    }

    List addList(List other) {
        if ( first.next == null) first.next = other.first;
        else {
            Node temp = first;
            while(temp.next != null) temp = temp.next;
            temp.next = other.first;
        }
        return this;
    }

    List addNode(int num) {
        Node nextNode = new Node();
        nextNode.num = num;

        if (first.next == null) first.next = nextNode;
        else {
            Node temp = first;
            while (temp.next != null) temp = temp.next;
            temp.next = nextNode;
        }
        return this;
    }

    void showList() {
        Node temp = this.first;
        int i = 1;
        while (temp != null) {
            System.out.println("Node " + i + ": " + temp.num);
            temp = temp.next;
            i++;
        }
    }

}

class ListIter {

    List list;
    static Node current;

    ListIter(List l) {
        list = l;
        current = l.first;
    }

    int First() {
        return list.first.num;
    }

    int Next() {
        int n = current.num;
        current = current.next;
        return n;
    }

    boolean NotNull() {
        if (current == null) return false;
        else return true;
    }

    boolean NextNotNull() {
        if (current.next == null) return false;
        else return true;
    }
}



public class MergeSort {

    public static int sum(List l) {

        ListIter Iter = new ListIter(l);

        int sum = 0;

        while (Iter.NotNull()) {
            sum += Iter.Next();
        }

        return sum;
    }

    public static int max(List l) {

        ListIter Iter = new ListIter(l);

        int max = 0;

        while (Iter.NotNull()) {
            int flag = Iter.Next();
            if (flag > max) max = flag;
        }

        return max;
    }

    public static int count(Node node) {
        int count = 0;
        Node temp = node;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void simpleSplit(List Exist, List Empty) {

        int count = 0;
        Node temp = Exist.first;
        while(temp != null) {
            temp = temp.next;
            count++;
        }

        int i = 0;
        Node setTemp =Exist.first;
        while ( i != count/2 -1) {
            setTemp = setTemp.next;
            i++;
        }

        Empty.first = setTemp.next;
        setTemp.next = null;
    }

    public static void split(List l, List[] a) {

        for ( int i = 0; i < a.length; i++) a[i] = new List();

        a[0] = l;
        int cnt = 0;
        int top = 1;

        while ( cnt != top ) {
            while ( a[cnt].first.next != null ) {
                simpleSplit(a[cnt], a[top]);
                top++;
            }
            cnt++;
        }
    }

    public static void simpleMerge(List Left, List Right) {

        Node p, q, np, head;
        p = Left.first;
        q = Right.first;
        np = null;
        head = null;

        while ( p != null && q != null ) {
            if ( head == null ) {
                if ( p.num <= q.num) {
                    head = p;
                    np = head;
                    p = p.next;
                }
                else if ( p.num > q.num ) {
                    head = q;
                    np = head;
                    q = q.next;
                }
            }
            else {
                if ( p.num <= q.num) {
                    np.next = p;
                    np = p;
                    p = p.next;
                }
                else if ( p.num > q.num ) {
                    np.next = q;
                    np = q;
                    q = q.next;
                }
            }
            np.next = null;
        }
        if ( p != null ) np.next = p;
        else if ( q != null ) np.next = q;

        Left.first = head;
    }

    public static void merge(List[] Array, int start, int end) {

        if ( start < end ) {
            int mid = (start + end) / 2;
            merge(Array, start, mid);
            merge(Array, mid + 1, end);

            int p = start;
            int q = mid + 1;
            simpleMerge(Array[p], Array[q]);
        }
    }

    public static void main(String[] args) {

        List l1 = new List(2);
        l1.addNode(6);
        l1.addNode(13);

        List l2 = new List(15);
        l2.addNode(11);
        l2.addNode(8);
        l2.addNode(9);
        l2.addNode(12);

        l1.addList(l2);

        int cnt = count(l1.first);

        List [] Arr = new List[cnt];

        split(l1, Arr);

        merge(Arr, 0, cnt - 1);

        l1.showList();

    }
}