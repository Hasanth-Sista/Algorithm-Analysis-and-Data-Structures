package hashImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HashingAlgorithm {
	public static int tablesize=2;
	public static float loadFactor=0;
	public static HashMap<Integer,String> hashMap=new HashMap<>(tablesize);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashingAlgorithm algorithm=new HashingAlgorithm();
		HashTable hashTable=new HashTable();

		List<String> list=new ArrayList<>(); 
		Scanner scanner=new Scanner(System.in);

		//		while(true){
		//			System.out.println("Enter the element to be added into the hash table ");
		//			String element=scanner.next();
		//			list.add(element);
		//			System.out.println("Do you want to insert element? Yes or No ");
		//			String s=scanner.next();
		//			if(s.equalsIgnoreCase("NO")){
		//				break;
		//			}	
		//		}
		list.add("elephant");
		list.add("tiger");
		list.add("lion");
		list.add("cheetah");
		list.add("deer");
		list.add("fox");
		list.add("peacock");
		list.add("rabbit");
		list.add("elephant");
		list.add("lion");
		list.add("bat");
		list.add("chameleon");
		list.add("zebra");
		list.add("duck");
		list.add("cockroach");
		list.add("hippopotamus");

		System.out.println("Initial tablesize is "+tablesize);
		algorithm.createHashTable(list, hashTable, algorithm);
		System.out.println("After adding elements tablesize is "+tablesize);
		for(String s:HashTable.collisions.keySet()){
			System.out.println("Number of collisions for element "+s+" is "+HashTable.collisions.get(s));
		}
		System.out.println("\nHashMap is :");
		System.out.println(hashMap+"\n");


		while(true){
			System.out.println("Enter 1.Search Element\n      2.Delete Element");
			String option=scanner.next();

			switch(option){

			case("1"):{	

				while(true){
					System.out.println("Enter the element to be searched......");
					String element=scanner.next();
					List<Integer> integers=hashTable.searchElement(element);

					if(integers.size()>0){
						System.out.println("Element found at indexes :");
						for(Integer i:integers){
							System.out.println(i);
						}
					}
					System.out.println("Do you want to search any other element? Yes or No");
					String answer=scanner.next();
					if(answer.equalsIgnoreCase("NO")){
						break;
					}
				}
				break;
			}

			case("2"):{

				System.out.println("HashMap before deletion of element\n"+HashingAlgorithm.hashMap+"\n");

				while(true){
					System.out.println("Enter the element to be deleted...");
					String element=scanner.next();
					hashTable.deleteElement(element);

					System.out.println("Do you want to delete any other element? Yes or No");
					String answer=scanner.next();
					if(answer.equalsIgnoreCase("NO")){
						break;
					}
				}
				break;
			}
			}
			System.out.println("Do you want to continue search and delete operations ? Yes or No");
			String s=scanner.next();
			if(s.equalsIgnoreCase("NO")){
				break;
			}
		}
	}

	private void createHashTable(List<String> list,HashTable hashTable,HashingAlgorithm algorithm){
		for(String s:list){
			if(loadFactor<=0.5){
				hashTable.addElement(s, tablesize, hashMap);
				loadFactor=(float)hashMap.size()/tablesize;
			}
			else{
				tablesize=algorithm.nextPrime(tablesize);
				hashMap=new HashMap<>(tablesize);
				loadFactor=0;
				break;
			}
		}
		if(hashMap.isEmpty()){
			algorithm.createHashTable(list, hashTable, algorithm);
		}

	}


	private int nextPrime(int size) {
		// TODO Auto-generated method stub
		int i;
		for(i=size+1;i<2*size;i++){
			if(i%2!=0){
				int count=0;
				for(int j=1;j<2*i;j++){
					if(i%j==0){
						count+=1;
					}
				}
				if(count==2){
					break;
				}
			}

		}
		return i;
	}

	public int hash(String key, int tablesize){

		int hashValue=0;

		char[] ch  = key.toCharArray();
		for(char c : ch)
		{
			int temp = (int)c;
			int temp_integer = 96; //for lower case
			if(temp<=122 & temp>=97){
				hashValue+=temp-temp_integer;
			}
		}

		return (hashValue * 11) % tablesize;
	}

}
