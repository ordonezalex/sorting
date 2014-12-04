import java.util.LinkedList;

public class Mergesort4 implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {
        LinkedList toSort = new LinkedList();
        for (int i = 0; i < unsorted.length; i++) {
            toSort.add(unsorted[i]);
        }

        mergesort(toSort.getFirst());
        return unsorted;
    }

    public Node mergesort(Object headOriginal) {
        Node head = (Node) headOriginal;
        if (head == null || head.next == null)
            return head;
        Node a = head;
        Node b = head.next;
        while ((b != null) && (b.next != null))
        {
            head = head.next;
            b = (b.next).next;
        }
        b = head.next;
        head.next = null;
        return merge(mergesort(a), mergesort(b));
    }

    public Node merge(Node a, Node b)
    {
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null))
        {
            if (a.item <= b.item)
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        c.next = (a == null) ? b : a;
        return head.next;
    }
}

class Node
{
    public int item;
    public Node next;
    public Node(int val)
    {
        item = val;
    }
    public Node()
    {}
    public void displayNode()
    {
        System.out.print(" " + item + " ");
    }
}
