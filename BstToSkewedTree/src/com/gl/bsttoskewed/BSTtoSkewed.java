package com.gl.bsttoskewed;
import com.gl.bsttoskewed.Node;
public class BSTtoSkewed {
	
	public static Node node;
	static Node prevNode=null;
	static Node headNode=null;

//	Function for make BST to Skewed Tree
	static void makeBSTtoSkewed(Node root,int order)
	{
		if(root==null) {
			return; //Base case
		}
		if(order>0) {
			makeBSTtoSkewed(root.right, order);
		}
		else {
			makeBSTtoSkewed(root.left, order);
		}
		Node rightNode=root.right;
		Node leftNode=root.left;
		
//		condition to check if the root node of the skewed tree is not defined.
		if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
		
		 // Similarly recurse for the left / right  subtree on the basis of the order required
		if (order > 0)
        {
			makeBSTtoSkewed(leftNode, order);
        }
        else
        {
        	makeBSTtoSkewed(rightNode, order);
        }
	}
	
//	function to traverse the right skewed tree.
	static void traverseRightSkewed(Node root) {
		if(root==null) {
			return;
		}
	
	System.out.print(root.val + " ");
    traverseRightSkewed(root.right);   
	}
	
//	Main Function
	public static void main(String args[]) {
		BSTtoSkewed tree=new BSTtoSkewed();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
		
//		Order of the skewed tree can define by 0 for Increasing order and 1 for decreasing order.
		 int order = 0;
		 makeBSTtoSkewed(node, order);
		 traverseRightSkewed(headNode);
	}
}
