package linkedlist;

public class InsertMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertMethod insertMethod=new InsertMethod();
		Node head=new Node();
		head.setValue(1);
		
		for(int i=2;i<10;i++){
			insertMethod.Insert(head, i);
		}
		while(head!=null){
			System.out.println(head.getValue());
			head=head.getNext();
		}
	}


	public void Insert(Node head,int tmp){
			if(head.getNext()==null){
				Node child=new Node();
				child.setValue(tmp);
				head.setNext(child);
				
			}
			else{
				head=head.getNext();
				Insert(head, tmp);
			}
	}
}
