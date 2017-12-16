package trees;

import java.util.Scanner;

public class TreeNode {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		TreeNode treeNode=new TreeNode();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("How many number of nodes in the tree ?");
		int a=scanner.nextInt();
		if(a>0){
			System.out.println("Enter the value of root node ");
			float b=scanner.nextFloat();
			Node node=new Node();
			node.setValue(b);
			a=a-1;
		if(a>0){
		System.out.println("Enter the values of other nodes ");
		}
		while(a>0){
			
			float key=scanner.nextFloat();
			treeNode.insertMethod(node, key);
			a=a-1;
		}
		
		Traverse traverse=new Traverse();
		traverse.bfs(node);
//		System.out.println("Inorder traversal before deletion");
//		traverse.inOrderTraverseMethod(node);
//		
//		System.out.println("Enter the value of node to be deleted ");
//		float delVal=scanner.nextFloat();
//		node=treeNode.deleteMethod(node,delVal);
//		System.out.println("Inorder traversal after deletion");
//		traverse.inOrderTraverseMethod(node);	
		}
		else{
			System.out.println("Please enter valid number of nodes greater than zero");
		}
	}

	
	public void insertMethod(Node root, float key){
		Node child=new Node();
		child.setValue(key);
		
		if(root==null){
			root=child;
		}
		else{
			while(true){
				if(root.getValue()<child.getValue()){
					if(root.getRight()==null){
						root.setRight(child);
						return;
					}
					else{
						root=root.getRight();
					}
				}
				else if(root.getValue()>=child.getValue()){
					if(root.getLeft()==null){
						root.setLeft(child);
						return;
					}
					else{
						root=root.getLeft();
					}
				}	
					
			}
					
		}
			
	}
	
	public Node searchMethod(Node root, double d){
		
		Node tmp;
		Node rightNode=root;
		while(root!=null){
			
		if(root.getValue()==(float)d){
			//System.out.println("success");
			break;
			}
		
		root=root.getLeft();
		tmp=root;
		if(tmp==null){
			root=rightNode.getRight();
			}
		}
		return root;
	}

	
	@SuppressWarnings("null")
	public Node deleteMethod(Node root, double d){
		

			
			Node delNode = null;
			delNode=root;
			Node parent=null;
			
			if(root!=null){

				while(true){
					if(delNode==null){
						break;
					}
					if(delNode.getValue()==(float)d){
						break;
						}
					if(delNode.getValue()<(float)d){
						parent=delNode;
						delNode=delNode.getRight();
						}
					else{
						parent=delNode;
						delNode=delNode.getLeft();
					}
				}
			}
			
			
			
			//System.out.println(delNode.getValue());
			
			if(delNode==null){
				return root;
			}
			
			
			// if no children, simply delete it
		    if(root.getLeft()==null &&  root.getRight()==null)
		         {
		         if(delNode == root){
		        	System.out.println("inside delete root");
		            root=null;     }            
		         else if(parent.getLeft()==delNode){
		            parent.setLeft(null);     }
		         else{                           
		            parent.setRight(null);}
		         }
		    // if no right child, replace with left subtree
		    else if(delNode.getRight()==null){
		         if(delNode == root){
		            root = delNode.getLeft();}
		         else if(parent.getLeft()==delNode){
		            parent.setLeft(delNode.getLeft());}
		         else{
		            parent.setRight(delNode.getLeft());}
		    }
		    // if no left child, replace with right subtree
		    else if(delNode.getLeft()==null){
		         if(delNode == root){
		            root = delNode.getRight();}
		         else if(parent.getLeft()==delNode){
		            parent.setLeft(delNode.getRight());}
		         else{
		            parent.setRight(delNode.getRight());}
		    }
		    else{
		    // two children
		    	//predecessor
				
				Node predecessor=delNode.getLeft();
				Node parentPredecessor=delNode;
				Node predecessorsLeft=null;
				
				if(predecessor!=null){
					while(predecessor.getRight()!=null){
						parentPredecessor=predecessor;
						predecessor=predecessor.getRight();
						predecessorsLeft=predecessor.getLeft();
						}
					}
				//successor

				
				Node successor=delNode.getRight();
				Node parentSuccessor=delNode;
				Node successorRight=null;
				
				if(predecessor==null){
					
					if(successor!=null){
						while(successor.getLeft()!=null){
							parentSuccessor=successor;
							successor=successor.getLeft();
							successorRight=successor.getRight();
							}
						}
					
				}
				
				//if both predecessor and successor are null
				
				if(predecessor==null && successor==null){
					if(parent.getLeft()==root){
						parent.setLeft(null);
						}
					if(parent.getRight()==root){
						parent.setRight(null);
						}
					}
				// if predecessor is there or successor is there
				else{
					if(parent==null){
						if(predecessor!=null){
							
							root.setValue(predecessor.getValue());
							parentPredecessor.setRight(predecessorsLeft);
						}
						else{
							root.setValue(successor.getValue());
							parentSuccessor.setLeft(successorRight);
						}
						
					}
					else{ 
						if(parent.getRight()==delNode){
							if(predecessorsLeft==null && predecessor!=null){
								parent.setRight(predecessor);
								predecessor.setRight(delNode.getRight());
								}
							else if(successorRight==null && successor!=null){
								parent.setRight(successor);
								successor.setRight(delNode.getLeft());
								}
							}
						else if(parent.getLeft()==delNode){
							if(predecessorsLeft==null && predecessor!=null){
								parent.setLeft(predecessor);
								predecessor.setRight(delNode.getRight());
							}
							else if(successorRight==null && successor!=null){
								parent.setLeft(successor);
								successor.setLeft(delNode.getLeft());
							}
							}
					
						}
				}
				
				
		    }
			
		return root;
				
	}
	
}
