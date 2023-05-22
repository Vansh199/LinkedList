//time complexity=O(n)
//space complexity=O(1)


public class SearchKey{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public void push(int newData){
        Node newNode = new Node(newData);
        newNode.next=head;
        head=newNode;
    }

    public boolean search(Node head,int x){
        Node curr=head;
        while(curr != null){
            if(curr.data==x){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }
    public static void main(String[] args) {
        SearchKey sk = new SearchKey();
        int x=13;
        sk.push(14);
        sk.push(21);
        sk.push(11);
        sk.push(30);
        sk.push(10);
        
        if(sk.search(sk.head, x)){
            System.out.println("yes");
        }
        else{
            System.out.println("No");
        }
    }
}