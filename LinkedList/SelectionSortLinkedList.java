package linkedlist;

import java.util.Scanner;


public class SelectionSortLinkedList {
	
	public Node insert(Node n){
		Scanner scanner=new Scanner(System.in);
		int c=scanner.nextInt();
		n.setValue(c);
		return n;
	}
	public void traverse(Node node){
		while(node!=null){
			System.out.print(node.getValue()+" ");
			node=node.getNext();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSortLinkedList linkedList=new SelectionSortLinkedList();
		System.out.println("Insert number of nodes");
		Scanner scanner=new Scanner(System.in);
		int a;
		a=scanner.nextInt();
		Node head=new Node();
		Node tmp1;
		tmp1=head;
		if(a!=0){
			System.out.println("Enter the value of node");
			int b=scanner.nextInt();
			head.setValue(b);
			a=a-1;
			while(a>0){
				Node tmp=new Node();
				tmp=linkedList.insert(tmp);
				head.setNext(tmp);
				head=head.getNext();
				a=a-1;
			}
		}
		scanner.close();

		System.out.println("Linkedlist before sorting");
		linkedList.traverse(tmp1);
		linkedList.selectsort(tmp1);
		
	}
	private void selectsort(Node head) {
		Node tmp=head;
		Node tmp3=head;
		Node tmp2;
		Node min;
		int minValue;
		while(tmp!=null){
			min=tmp;
			tmp2=tmp.getNext();
			while(tmp2!=null){
				if(min.getValue()>tmp2.getValue()){
					min=tmp2;
				}
				tmp2=tmp2.getNext();
			}
			minValue=tmp.getValue();
			tmp.setValue(min.getValue());
			min.setValue(minValue);
			tmp=tmp.getNext();
		}
		System.out.println("LinkedList after sorting");
		traverse(tmp3);
	}
}
