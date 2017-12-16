package graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchGraph {
	
	public static int[][] matrix;
	public static int vertices;
	public static List<LinkedList<Integer>> linkedList;
	public static Queue<Long> queue=new LinkedList<>();
	public static Queue<Integer> queue1=new LinkedList<>();
	
	
	public BreadthFirstSearchGraph(int v) {
		linkedList=new ArrayList<>();
		for(int i=0;i<v;i++){
			LinkedList<Integer> list=new LinkedList<>();
			list.add(i);
			linkedList.add(list);
		}
	}
	public void bfs(int vertex) {
		if(!queue.contains((long)vertex)){
			queue.add((long)vertex);
		}
		
		for(int i=0;i<vertices;i++){
			if(matrix[vertex][i]==1){
				if(!queue.contains((long)i)){
					queue1.add(i);
				}
			}
		}
		
		
		for(Integer num: queue1){
			if(!queue.contains((long)num)){
				queue.add((long) num);
			}
		}
		
		for (int i=0;i<queue1.size();i++) {
			if(!queue1.isEmpty()){
				bfs(queue1.remove());
			}
		}
		
		
	}
	
	public void createGraph(int v1,int v2){
		
		for(int i=0;i<linkedList.size();i++){
			if(linkedList.get(i).get(0)==v1){
				linkedList.get(i).addLast(v2);
			}
		}


	}
		
	public static void main(String[] args) {

		System.out.println("Enter the number of vertices :");
		Scanner scanner=new Scanner(System.in);
		int v=scanner.nextInt();
		
		BreadthFirstSearchGraph obj=new BreadthFirstSearchGraph(v);
		vertices=v;
		
		
		while(true){
			System.out.println("Enter the vertices connected to each other: vertice1 and vertice2 :");
			
			int v1=scanner.nextInt();
			int v2=scanner.nextInt();
			
			
			
			obj.createGraph(v1, v2);
			System.out.println("Do you want to enter more: Y or N ");
			String s=scanner.next();
			if(s.equals("N")){
				break;
			}
		}
		
		obj.createMatrix();
		System.out.println("Enter the vertex from which bfs should be performed :");
		int va=scanner.nextInt();
		obj.bfs(va);
				
		
		for(int i=0;i<vertices;i++){
			if(!queue.contains(i)){
				obj.bfs(i);
			}
		}
		
		System.out.println("Breadth First Search for the graph is :");
		for (Long a : queue) {
			System.out.print(a+" ");
		}
	}
	private void createMatrix() {
		matrix=new int[vertices][vertices];
		
		for(int i=0;i<linkedList.size();i++){
			LinkedList<Integer> list=linkedList.get(i);
			
			for(int k=1;k<list.size();k++){
				if(list.get(k)!=null){
					matrix[i][list.get(k)]=1;	
				}
			}
		}
		
		System.out.println("Adjacency Matrix");
		for(int j=0;j<vertices;j++){
			for(int k=0;k<vertices;k++){
				System.out.print(matrix[j][k]+" ");
			}
			System.out.println();
		}
		
	}
}
