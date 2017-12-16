package avl;

public class Node {
	
	private float key;
	private int height;
	private Node leftNode;
	private Node rightNode;
	private Node parent;
	
	
	public float getKey() {
		return key;
	}
	public void setKey(float key) {
		this.key = key;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
}
