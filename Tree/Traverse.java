package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traverse {
	
	
	public void bfs(Node root){
		Queue<trees.Node> queue = new LinkedList<trees.Node>();
		    if (root == null)
		        return;
		    queue.clear();
		    queue.add(root);
		    while(!queue.isEmpty()){
		        Node node = queue.remove();
		        System.out.print(node.getValue() + " ");
		        if(node.getLeft() != null) queue.add(node.getLeft());
		        if(node.getRight() != null) queue.add(node.getRight());
		    }

	}
	
	public void inOrderTraverseMethod(Node root){
		if(root!=null){
			inOrderTraverseMethod(root.getLeft());
			System.out.println(root.getValue());
			inOrderTraverseMethod(root.getRight());
		}	
	}
	
	public void preOrderTraverseMethod(Node root){
		if(root!=null){
			System.out.println(root.getValue());
			preOrderTraverseMethod(root.getLeft());
			preOrderTraverseMethod(root.getRight());
		}	
	}
	
	public void postOrderTraverseMethod(Node root){
		if(root!=null){
			postOrderTraverseMethod(root.getLeft());
			postOrderTraverseMethod(root.getRight());
			System.out.println(root.getValue());
		}	
	}

	
}
