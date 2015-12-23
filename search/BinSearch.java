package search;
/* Arnold Lin 12/22/2015
 * Multi-language Toolbox Java section
 * Binary Search
 * 		w/ test interface
 *  DONE:
 *    Basic Binary Search
 *  TODO: 
 *    Adding Cache
 */

import java.util.List;

/*Used for TEST*/
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinSearch<T extends Comparable<T>>{
	
	private int cacheSize = 0;
	
	// Default Constructor
	public BinSearch(){
		
	}
	
	// Constructor setting up cache size
	public BinSearch(int cachesize){
		this();
		cacheSize = cachesize;
	}
	
	/**
	 * @param list:  A List containing type T
	 * @param key: A element to be found 
	 * 
	 * @return A integer indicating the index of the element
	 *      -1 if not found
	 */
	
	public int search(List<T> list, T key){
		int from = 0;
		int to = list.size();
		while(from < to){
			int mid = (from+to)>>>1;
			int comp = list.get(mid).compareTo(key);
			if(comp == 0)
				return mid;
			else if(comp < 0)
				from = mid+1;
			else
				to = mid;
		}
		return -1;
	}
	
	//Testing Main
	@Test
	/**
	 * @param args[0] <optional> length of the testing list
	 * @param args[1] <optional> the distance between the values of adjacent integers
	 * @param args[2] <optional> the times of random selection test
	 */
	public static void main(String[] args){
		Random r = new Random();
		int n = 10;
		int step = 40;
		int depth = 5;
		int k = 0;
		
		switch(args.length){
		case 3:
			depth = Integer.parseInt(args[2]);
		case 2:
			step = Integer.parseInt(args[1]);
		case 1:
			n = Integer.parseInt(args[0]);
		default:
			break;
		}
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			test.add((k += r.nextInt(step)));
		
		System.out.println("Binary Search Test");
		System.out.printf("Array Size:%d\tStep:%d\n",n,step);
		System.out.println(test);
		BinSearch<Integer> b = new BinSearch<Integer>(10);
		
		k = 0;
		while((k++) < depth){
			int rand = r.nextInt(3*n/2);
			int key, ind;
			if(rand < n){
				key = test.get(rand);
				ind = b.search(test, new Integer(key));
				System.out.printf("Ind = %d\tkey=%d\n",rand,key);
				assertTrue(ind >= 0);
				assertEquals(new Integer(key), test.get(ind));
			}else{
				key = -test.get(rand*2/3);
				assertTrue(b.search(test, new Integer(key)) < 0);
			}
		}
		System.out.println("PASSED.");
	}
}
