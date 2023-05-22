//time complexity=O(m+n)
//space complexity=O(m+n)


public class SumList {
    static Node head1, head2;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Adds contents of two linked lists and prints it */
    public void addTwoLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;
 
        addPrecedingZeros(start1, start2);
        Node result = new Node(0);
        if (sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }
        printList(result.next);
    }
 
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    /* Adds lists and returns the carry */
    public int sumTwoNodes(Node first, Node second, Node result) {
        if (first == null) {
            return 0;
        }
        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
        Node node = new Node(number % 10);
        node.next = result.next;
        result.next = node;
        return number / 10;
    }
 
    /* Appends preceding zeros in case a list is having lesser nodes than the other one*/
    public void addPrecedingZeros(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;
        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 != null) {
            while (next2 != null) {
                Node node = new Node(0);
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if (next2 == null && next1 != null) {
            while (next1 != null) {
                Node node = new Node(0);
                node.next = start2.next;
                start2.next = node;
                next1 = next1.next;
            }
        }
    }

    public static void main(String[] args) {
        
        SumList list = new SumList();
 
        // creating first list
        list.head1 = new Node(5);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(3);
        
        System.out.print("First list is ");
        list.printList(head1);
 
        // creating second list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        list.head2.next.next = new Node(2); 
        System.out.print("Second list is ");
        list.printList(head2);
 
        System.out.print("Resultant list is ");
        // add the two lists and see the result
        list.addTwoLists(head1, head2);
    }
    
}