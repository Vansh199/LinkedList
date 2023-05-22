//time complexity=O(n)
//space complexity=O(1)

public class RemoveDuplicates {

    Node head;
    
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    //implementation of insertion of node at beginning
    public void push(int newData){
        Node newNode = new Node(newData);
        newNode.next=head;
        head=newNode;
    }

    public void removeDuplicates()
    {
        // Two references to head temp will iterate to the
        // whole Linked List prev will point towards the
        // first occurrence of every element
        Node temp = head, prev = head;
 
        // Traverse list till the last node
        while (temp != null) {
 
            // Compare values of both pointers
            if (temp.data != prev.data) {
                // if the value of prev is not equal to the
                // value of temp that means there are no
                // more occurrences of the prev data. So we
                // can set the next of prev to the temp
                // node.
                prev.next = temp;
                prev = temp;
            }
            // Set the temp to the next node
            temp = temp.next;
        }
        // This is the edge case if there are more than one
        // occurrences of the last element
        if (prev != temp)
            prev.next = null;
    }
    // display all the nodes after the insertion
    public void printNodes(){
        Node current = head;
        while(current!= null){
            System.out.print(current.data+" ");
            current = current.next;

        }
    }
    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.push(1);
        rd.push(1);
        rd.push(2);
        rd.push(3);
        rd.push(3);
        System.out.println("Before remove duplicates");

        rd.printNodes();
        System.out.println();
        rd.removeDuplicates();
        System.out.println("After removing duplicates");
        rd.printNodes();
    }
}
