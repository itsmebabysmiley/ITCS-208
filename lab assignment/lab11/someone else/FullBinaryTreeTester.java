import java.util.ArrayList;

public class FullBinaryTreeTester {
	
	public static void inOrderTraverse(Node root)
	{
		//YOUR CODE GOES HERE
		if(root != null) {
			inOrderTraverse(root.left);
			System.out.print(root.id+" ");
			inOrderTraverse(root.right);
		}
	}
	
	public static boolean isFullBinTree(Node root)
	{	//YOUR CODE GOES HERE
		if(root == null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		if(root.left!=null && root.right!=null) {
			return isFullBinTree(root.left) && isFullBinTree(root.right);
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
	public static void printBinTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		if(root.left!=null&&root.right!=null) {
            System.out.println("        "+root.id);
            System.out.println("      /   \\");
            System.out.println("     "+root.left.id+"     "+root.right.id);
            System.out.println("    / \\   / \\");
            System.out.println("   "+root.left.left.id+"   "+root.left.right.id+" "+root.right.left.id+"  "+root.right.right.id);
        }
	}
	static ArrayList<Integer> node = new ArrayList<>();
	public static void change(Node root) {
		if(root != null) {
			if(root.left!=null) {
				change(root.left);
			}
			node.add(root.id);
			if(root.right!=null) {
				change(root.right);
			}
		}
		for(int i=0;i<node.size();i++) {
			for(int j=1;j<node.size()-i;j++) {
				if(node.get(j-1)>node.get(j)) {
					int temp;
					temp = node.get(j-1);
					node.set(j-1, node.get(j));
					node.set(j, temp);
				}
			}
		}

	}
	public static Node newnode(int start, int end) {  // 1 3 4 *6* 7 8 10
		if(start>end) {
			return null;
		}
		int mid=(start+end)/2;
		Node newnode2 = new Node(node.get(mid),newnode(start,mid-1),newnode(mid+1,end));
		return newnode2;
	}
	public static Node getBinSearchTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		change(root);
		return newnode(0,node.size()-1);
	}
	public static void bonusTester()
	{
		Node t = new Node(1, new Node(2, new Node(3, null, null), new Node(4, null, null)), 
				new Node(5, new Node(6, null, null), new Node(7, new Node(8,null,null),new Node(9,null,null))));
		System.out.println("Before Transforming: ");
		print(t);
		System.out.println();
		printBinTree(t);
		System.out.println("After Transforming: ");
		printBinTree(getBinSearchTree(t));
		
	}
	public static void print(Node root) {
		if(root != null){

			print(root.left);
			System.out.print(root.id+" ");
			print(root.right);
		}
	}
	/**************BONUS ENDS***************/
	
	
	
	public static void main(String[] args)
	{
		normalTester();
		
		//Uncomment for bonus
		bonusTester();
	}
}
