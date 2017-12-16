package avl;

public class Traverse {

	public void inOrderTraverseMethod(Node root){
		if(root!=null){
			inOrderTraverseMethod(root.getLeftNode());
			System.out.println(root.getKey());
			inOrderTraverseMethod(root.getRightNode());
		}	
	}
	
	public void preOrderTraverseMethod(Node root){
		if(root!=null){
			System.out.println(root.getKey());
			preOrderTraverseMethod(root.getLeftNode());
			preOrderTraverseMethod(root.getRightNode());
		}	
	}
	
	public void postOrderTraverseMethod(Node root){
		if(root!=null){
			postOrderTraverseMethod(root.getLeftNode());
			postOrderTraverseMethod(root.getRightNode());
			System.out.println(root.getKey());
		}	
	}

	
}
