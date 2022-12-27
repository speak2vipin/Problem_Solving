//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class PalindromeLL{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Node head=null;
			head=insert(head,sc.nextInt());
			for(int i=1;i<n;i++)
				insert(head,sc.nextInt());
			GfG g=new GfG();
			System.out.println(g.maxPalindrome(head));
		}
	}
	public static Node insert(Node head,int val){
		if(head==null)
			return new Node(val);
		head.next=insert(head.next,val);
		return head;
	}
	/*public static void print(Node head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}*/
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class GfG
{
        public static int maxPalindrome(Node A)
        {
          int len = 1;
		Node curr = null;
		Node prev = null;
		Node temp;

		while (A != null) {
			curr = A;
			A = A.next;
			curr.next = prev;
			prev = curr;
			temp = A;
            // EVEN LENGTH CALCULATION
			int evenLength =  match(curr, temp);
			len = Math.max(evenLength, len);
			
			if (A!=null && A.next != null) {
                // ODD LENGTH i.e. MATCHING BOTH SIDE OF CURRENT NODE 
				int oddLength = match(curr, A.next);
				len = Math.max(oddLength + 1, len);
			}
		}
		return len;
	}

	static int match(Node forward, Node backward) {
		int count = 0;
		while (forward != null && backward != null && forward.data == backward.data) {
			forward = forward.next;
			backward = backward.next;
			count += 2;
		}
		return count;
	}
}