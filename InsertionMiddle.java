//time complexity=O(n)
//space complexity=O(1)


public class InsertionMiddle {
    
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
    
         public void insertAtMiddle(Node prev_node,int newData){
          if(prev_node==null){
            System.out.println("previous node can not contain null value");
            return;
          }
           Node newNode = new Node(newData);
           newNode.next=prev_node.next;
           prev_node.next=newNode; 
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
            InsertionMiddle llist = new InsertionMiddle();
     
            llist.push(1);
            llist.push(2);
            llist.push(4);
            llist.push(5);
            llist.push(6);
            System.out.println("Before insertion");
            llist.printNodes();
            
            llist.insertAtMiddle(llist.head.next, 3);
            System.out.println("After insertion");
            llist.printNodes();
    
        }
    
}
