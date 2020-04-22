import java.util.*;

public class FullBinaryTreeTester {
	
	public static void inOrderTraverse(Node root)
	{
		//YOUR CODE GOES HERE
		if (root == null) return; 
		
        inOrderTraverse(root.left); 
		System.out.print(root.id + " "); 
        inOrderTraverse(root.right); 
	}
	
	public static boolean isFullBinTree(Node root)
	{	//YOUR CODE GOES HERE
		if(root == null)  return true;		//checj empty tree.
        
        if(root.left == null && root.right == null ) return true;		//check leaf node.

		if((root.left!=null) && (root.right!=null)){		//check left and right aren't null.
			return (isFullBinTree(root.left) && isFullBinTree(root.right));		//check left and right are full tree.	
		}
           
        return false; 
	}
	
	public static void normalTester()
	{
		Node[] ts = new Node[7];
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(14, null, null), null);
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, null, null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				null);
		
		for(int i = 0; i < ts.length; i++)
		{
			System.out.print("[T"+i+"] in-order: ");
			inOrderTraverse(ts[i]);
			System.out.println("\n[T"+i+"] is"+(isFullBinTree(ts[i])?" ":" NOT ")+"a full binary tree.\n");
		}
		
	}
	
	
	/**************BONUS STARTS***************/
	static List<Integer> q = new LinkedList<Integer>();
	
	public static void printBinTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		if (root == null) return;
		printBinTree(root.left);
		System.out.print(root.id+" ");
		q.add(root.id);
		printBinTree(root.right);
	}
	static Node2 root2;
	static void inorderRec(Node2 root) {
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.key+" "); 
            inorderRec(root.right); 
        } 
    } 
	void insert(int key) 
    { 
        root2 = insertRec(root2, key); 
    } 
    Node2 insertRec(Node2 root, int key) 
    { 
  
        if (root == null) 
        { 
            root = new Node2(key); 
            return root; 
        } 
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
        return root; 
    } 
	static boolean for_wat = true;
	public static Node getBinSearchTree(Node root) { // YOUR BONUS CODE GOES HERE
		if (for_wat) {
			Collections.sort(q);
			FullBinaryTreeTester f = new FullBinaryTreeTester();
			for (int i = 0; i < q.size(); i++) {
				f.insert(q.get(i));
			}
			inorderRec(root2);
			for_wat = false;
		}

		return null;

	}
	public static void bonusTester()
	{
		Node t = new Node(1, new Node(2, new Node(3, null, null), new Node(4, null, null)), 
				new Node(5, new Node(6, null, null), new Node(7, new Node(8,null,null),new Node(9,null,null))));
		System.out.println("Before Transforming: ");
		printBinTree(t);
		System.out.println();
		System.out.println("After Transforming: ");
		getBinSearchTree(getBinSearchTree(t));
				
	}
	/**************BONUS ENDS***************/
	
	
	
	public static void main(String[] args)
	{
		normalTester();
		
		//Uncomment for bonus
		bonusTester();
	}
}

class Node2 
    { 
        int key; 
        Node2 left, right; 
  
        public Node2(int item) 
        { 
            key = item; 
            left = right = null; 
        } 
    } 