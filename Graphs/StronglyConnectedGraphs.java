package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class StronglyConnectedGraphs {
		
		public static int[][] matrix;
		public static int vertices;
		public static List<LinkedList<Integer>> linkedList;
		public static Queue<Long> queue1;
		public static List<Queue<Long>> listL;
		public static List<Integer> array;
		public static List<Boolean> booleans;
		public static List<List<Boolean>> booleanExps;
		
		public void createLinkedListandQueue() {
			StronglyConnectedGraphs.listL=new ArrayList<>();

			StronglyConnectedGraphs.queue1=new LinkedList<>();
			for(long i=0;i<vertices;i++){
				StronglyConnectedGraphs.queue1.add(i);
			}
			for(int i=0;i<vertices;i++){
				StronglyConnectedGraphs.listL.add(new LinkedList<>(queue1));
			}
			
		}
		public StronglyConnectedGraphs(int v){
			linkedList=new ArrayList<>();
			
			for(int i=0;i<v;i++){
				LinkedList<Integer> list=new LinkedList<>();
				list.add(i);
				linkedList.add(list);
			}		
		}
		
		public LinkedList<Integer> linklistMethod(int vertex){
			return linkedList.get(vertex);
		}
		
		public void strongConnection(int vertex, int v) {
			
			if(!array.contains(v))
				StronglyConnectedGraphs.array.add(v);
			
			LinkedList<Integer> linklist=linklistMethod(v);
			
			for(int i=0;i<linklist.size();i++){
				if(i!=vertex){
					StronglyConnectedGraphs.listL.get(vertex).remove((long)linklist.get(i));
					}
			}
			
			List<LinkedList<Integer>> list1 = new ArrayList<>();
			for(int i=0;i<linklist.size();i++){
				if(i!=vertex){
					list1.add(linklistMethod(linklist.get(i)));
					}
			}
			
			for(int i=0;i<list1.size();i++){
				for(int j=0;j<list1.get(i).size();j++){
					if(!StronglyConnectedGraphs.array.contains(list1.get(i).get(j))){
						strongConnection(vertex,list1.get(i).get(j));
					}
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

			System.out.println("Enter the number of vertices for graphs :");
			Scanner scanner=new Scanner(System.in);
			int v=scanner.nextInt();
			
			StronglyConnectedGraphs obj1=new StronglyConnectedGraphs(v);
			vertices=v;
			
			while(true){
				System.out.println("Enter the vertices connected to each other: vertice1 and vertice2 :");
				int v1=scanner.nextInt();
				int v2=scanner.nextInt();
			
				obj1.createGraph(v1, v2);
				System.out.println("Do you want to enter more: Y or N ");
				String s=scanner.next();
				if(s.equals("N")){
					break;
				}
			}
			
			obj1.createMatrix();
			obj1.createLinkedListandQueue();
				
			
			
			booleanExps=new ArrayList<>();
			
			for(int i=0;i<vertices;i++){	
					booleans=new ArrayList<>();
					StronglyConnectedGraphs.array=new ArrayList<>();
					obj1.strongConnection(i, i);	
					for(int j=0;j<vertices;j++){
						if(StronglyConnectedGraphs.array.contains(j)){
							StronglyConnectedGraphs.booleans.add(true);
						}else{
							StronglyConnectedGraphs.booleans.add(false);
						}
					}
					booleanExps.add(booleans);
					
					StronglyConnectedGraphs.listL.remove(i);
					StronglyConnectedGraphs.listL.add(i, new LinkedList<>(queue1));
				}
			
			System.out.print("Graph is strongly connected - ");
			System.out.print(obj1.stronglyConnected());
						
		}
		

		private boolean stronglyConnected() {
			// TODO Auto-generated method stub

			for(int i=0;i<booleanExps.size();i++){
				for(int j=0;j<booleanExps.size();j++){
					if(booleanExps.get(i).get(j)==false){
						return false;
					}
				}
			}
			return true;
			
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
