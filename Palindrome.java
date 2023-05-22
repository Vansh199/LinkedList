//time complexity=O(n)
//space complexity=O(n)



public class Palindrome {
    Node head;
    Node left;
    
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

    boolean isPalindromeUtil(Node right)
    {
        left = head;
 
        // Stop recursion when right becomes null
        if (right == null)
            return true;
 
        // If sub-list is not palindrome then no need to
        // check for the current left and right, return
        // false
        boolean isp = isPalindromeUtil(right.next);
        if (isp == false)
            return false;
 
        // Check values at current left and right
        boolean isp1 = (right.data == left.data);
 
        left = left.next;
 
        // Move left to next node;
        return isp1;
    }
    
    boolean isPalindrome(Node head)
    {
        boolean result = isPalindromeUtil(head);
        return result;
    }
    public static void main(String[] args) {
        Palindrome llist = new Palindrome();

        llist.push(1);
        llist.push(2);
        llist.push(2);
        llist.push(1);
        
        if (llist.isPalindrome(llist.head)) {
            System.out.println("true");
            System.out.println("");
        }
        else {
            System.out.println("false");
            System.out.println("");
        }
    }
}
