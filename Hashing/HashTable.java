package hashImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class HashTable {
	public static HashMap<String, Integer> collisions=new HashMap<>();
	
	public void addElement(String element, int tablesize, HashMap<Integer, String> hashMap){
		HashingAlgorithm algorithm=new HashingAlgorithm();
		int hashCode=algorithm.hash(element, tablesize);
		
		if(hashMap.get(hashCode)==null){
			hashMap.put(hashCode, element);
		}
		else{
			int count=0;
			while(true){
				hashCode=(hashCode+1)%tablesize;
				count+=1;
				if(hashMap.get(hashCode)==null){
					hashMap.put(hashCode, element);
					collisions.put(element, count);
					//System.out.println("Number of collisions for element "+element+" is "+count+" for tablesize "+tablesize);
					break;
					}
				}
			}
		
	}
	
	public void deleteElement(String element){
		Scanner scanner=new Scanner(System.in);
		
		HashTable hashTable=new HashTable();
		List<Integer> integers=hashTable.searchElement(element);
		
		if(integers.size()>0){
			if(integers.size()==1){
				HashingAlgorithm.hashMap.remove(integers.get(0), element);
			}
			else if(integers.size()>1){
				HashingAlgorithm.hashMap.remove(integers.get(0),element);
			}
			System.out.println("HashMap after deletion of element\n"+HashingAlgorithm.hashMap);
		}
		
	}
	
	public List<Integer> searchElement(String element){
		
		List<Integer> keyPositions=new ArrayList<>();
		for (Entry<Integer, String> entry : HashingAlgorithm.hashMap.entrySet()) {
	        if (entry.getValue().equals(element)) {
	            keyPositions.add(entry.getKey());
	        }
	    }
		if(keyPositions.size()==0){
			System.out.println("Element not found");
		}
		return keyPositions;
	}
}
