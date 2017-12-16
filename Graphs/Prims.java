package mst;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Prims {
	
	private static PriorityQueue<Integer> priorityQueue;
	private static HashMap<String, Integer> hashMap;
	private static int[][] matrix;
	private static String parent[][];
	private static int distance[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prims prims=new Prims();
		hashMap=new HashMap<>();
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("Enter the edge :");
			String edge=scanner.next();
			String v1=edge.substring(0,1);
			String v2=edge.substring(2);
			System.out.println("Enter the weight of edge :");
			String weight=scanner.next();
			hashMap.put(edge, Integer.valueOf(weight));
			System.out.println("Do you want to continue: Y or N");
			String s=scanner.next();
			if(!s.equalsIgnoreCase("Y")){
				break;
			}
		}
		int maxval=0;
		for(String key:hashMap.keySet()){
			String vertice1=key.substring(0, 1);
			String vertice2=key.substring(2);
			if(maxval<Integer.valueOf(vertice1)){
				maxval=Integer.valueOf(vertice1);
			}
			if(maxval<Integer.valueOf(vertice2)){
				maxval=Integer.valueOf(vertice2);
			}
		}
		matrix=new int[maxval+1][maxval+1];
		for(String key:hashMap.keySet()){
			String vertice1=key.substring(0, 1);
			String vertice2=key.substring(2);
			matrix[Integer.valueOf(vertice1)][Integer.valueOf(vertice2)]=1;
			matrix[Integer.valueOf(vertice2)][Integer.valueOf(vertice1)]=1;
		}
		System.out.println("Matrix Representation : ");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		priorityQueue=new PriorityQueue<>();
		parent=new String[maxval+1][1];
		distance=new int[maxval+1][1];
		for(int i=0;i<distance.length;i++){
			distance[i][0]=1000000;
		}
		String initialElement=prims.findMinimumVertice();
		distance[Integer.valueOf(initialElement)][0]=0;
		parent[Integer.valueOf(initialElement)][0]=null;
		while(!priorityQueue.contains(Integer.valueOf(initialElement))){
				int index=0;
				if(!priorityQueue.contains(initialElement)){
					prims.doPrim(initialElement);
					int minval=1000000;
					for(int i=0;i<distance.length;i++){
						if(distance[i][0]<minval && i!=Integer.valueOf(initialElement) && !priorityQueue.contains(i)){
							minval=distance[i][0];
							index=i;
						}
					}	
				}
				for(int i=0;i<distance.length;i++){
					if(distance[i][0]==0){
						parent[i][0]=null;
					}
				}
				initialElement=String.valueOf(index);		
			}
		
		
		System.out.println("Minimum spanning tree :");
		System.out.println("Edge                      Weight");
		for(int i=0;i<=maxval;i++){
			if(parent[i][0]!=null){
				System.out.println(parent[i][0]+"-"+i+"                        "+distance[i][0]);
			}
		}
		
	}
	private void doPrim(String initialElement) {
		// TODO Auto-generated method stub
			priorityQueue.add(Integer.valueOf(initialElement));
			for(int i=0;i<matrix.length;i++){
				if(matrix[Integer.valueOf(initialElement)][i]==1 && !priorityQueue.contains(Integer.valueOf(i))){
					int val=0;
					if(hashMap.get(initialElement+"-"+i)!=null){
						val=hashMap.get(initialElement+"-"+i);
					}	
					else{
						val=hashMap.get(i+"-"+initialElement);
					}
					int val1=distance[i][0];
					if(val1>=val){
						distance[i][0]=val;
						parent[i][0]=initialElement;
					}
					if(parent[i][0]==null){
						parent[i][0]=initialElement;
					}	
				}
			}
	}
	private String findMinimumVertice() {
		// TODO Auto-generated method stub
		int minval=1000000;
		for(Integer val:hashMap.values()){
			if(val<minval){
				minval=val;
			}
		}
		String initialKey=null;
		for (Entry<String,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(minval)) {
                initialKey=entry.getKey();
            }
        }
		String initialElement=initialKey.substring(0,1);
		return initialElement;
	}
}