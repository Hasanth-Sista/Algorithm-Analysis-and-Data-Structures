package avl;

import java.util.Scanner;

public class AvlNode {
	
	
	public Node searchMethod(Node root,float key){
		Node tmp;
		Node rightNode=root;
		while(root!=null){
			
		if(root.getKey()==(float)key){
			break;
			}
		
		root=root.getLeftNode();
		tmp=root;
		if(tmp==null){
			root=rightNode.getRightNode();
			}
		}
		return root;
		
	}
	
	public int height(Node root) {
        if (root == null)
            return 0;
        else
        	return root.getHeight();
    }
	public int getBalance(Node root) {
        if (root == null)
            return 0;
        else
        	return height(root.getLeftNode()) - height(root.getRightNode());
    }
	 public Node rightRotate(Node node2) {
	        Node node1 = node2.getLeftNode();
	        Node node3 = node1.getRightNode();
	 
	     
	        node1.setRightNode(node2);
	        node2.setLeftNode(node3);
	        
	        if(height(node2.getLeftNode())>height(node2.getRightNode())){
	        	node2.setHeight(height(node2.getLeftNode())+1);
	        }
	        else{
	        	node2.setHeight(height(node2.getRightNode())+1);
	        }
	        
	        if(height(node1.getLeftNode())>height(node1.getRightNode())){
	        	node1.setHeight(height(node1.getLeftNode())+1);
	        }
	        else{
	        	node1.setHeight(height(node1.getRightNode())+1);
	        }
	       
	        
	        return node1;
	    }
	 
	   
	    public Node leftRotate(Node node1) {
	        Node node2 = node1.getRightNode();
	        Node node3 = node2.getLeftNode();
	 
	        
	        node2.setLeftNode(node1);
	        node1.setRightNode(node3);
	        
	        if(height(node1.getLeftNode())>height(node1.getRightNode())){
	        	node1.setHeight(height(node1.getLeftNode())+1);
	        }
	        else{
	        	node1.setHeight(height(node1.getRightNode())+1);
	        }
	        
	        if(height(node2.getLeftNode())>height(node2.getRightNode())){
	        	node2.setHeight(height(node2.getLeftNode())+1);
	        }
	        else{
	        	node2.setHeight(height(node2.getRightNode())+1);
	        }
	        
	        
	        return node2;
	    }
	    
	    public Node insert(Node root, float key) {
		 	
		 	Node child=new Node();
		 	child.setKey(key);
	     
	        if (root == null)
	            root=child;
	 
	        if (key < root.getKey())
	            root.setLeftNode(insert(root.getLeftNode(), key));
	        else if (key > root.getKey())
	            root.setRightNode(insert(root.getRightNode(), key));
	        else 
	            return root;
	 
	        
	        root.setHeight(1 + Math.max(height(root.getLeftNode()),height(root.getRightNode())));
	       
	        
	        int balance = getBalance(root);
	    
	        // Left Left Case
	        if (balance > 1 && key < root.getLeftNode().getKey()){
	            return rightRotate(root);}
	 
	        // Right Right Case
	        if (balance < -1 && key > root.getRightNode().getKey()){
	            return leftRotate(root);}
	 
	        // Left Right Case
	        if (balance > 1 && key > root.getLeftNode().getKey()) {	
	            root.setLeftNode(leftRotate(root.getLeftNode()));
	            return rightRotate(root);
	        }
	 
	        // Right Left Case
	        if (balance < -1 && key < root.getRightNode().getKey()) {
	            root.setRightNode(rightRotate(root.getRightNode()));
	            return leftRotate(root);
	        }
	 
	       
	        return root;
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvlNode avlNode=new AvlNode();
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of nodes in the AVL tree : ");
		float count=scanner.nextFloat();
		if(count>0){
			System.out.println("Enter the value of root node :");
			float val=scanner.nextFloat();
			Node root=new Node();
			root.setKey(val);
			System.out.println("Enter the value of nodes to be inserted in the tree :");
			count--;
			for(int i=1;i<=count;i++){
				float key=scanner.nextFloat();
				root=avlNode.insert(root, key);
				}
			Traverse traverse=new Traverse();
			System.out.println("Inorder traversal of AVL tree is :");
			traverse.inOrderTraverseMethod(root);
			
		}
		else{
			System.out.println("Enter nodes greater than zero");
		}
	}

}
