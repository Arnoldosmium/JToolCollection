/* Arnold Lin 12/23/2015
 * Multi-language Toolbox Java section
 * Heap Tester
 *  DONE:
 *    Testing method
 */
package heap;
import java.util.ArrayList;
import java.util.Random;

import shuffle.*;

public class HeapTester {

	private static boolean test(ArrayList<Integer> heap, int parent){
		if(parent*2 < heap.size()){
			if(heap.get(parent).compareTo(heap.get(parent*2)) < 0)	return false;
			if(!test(heap, parent*2))	return false;
		}
		if(parent*2+1 < heap.size()){
			if(heap.get(parent).compareTo(heap.get(parent*2+1)) < 0)	return false;
			if(!test(heap, parent*2+1))	return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ArrayHeap<Integer> h = new ArrayHeap<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int N = 100;
		int range = 10;
		Random r = new Random();
		for(int i = 0; i < N; i++)
			arr.add(r.nextInt(range));
		new KnuthShuffle<Integer>().getShuffle(arr);
		
		for(Integer i : arr){
			h.add(i);
		}
		
		if(!test(h.getHeap(), 1)){
			throw new Exception("HEAP ARRAY MISCONFIGUED.");
		}
		
		int k = h.removeMax();
		while(!h.isEmpty()){
			if(k < h.peek())
				throw new Exception("HEAP PEEK A LARGER NUMBER");
			k = h.removeMax();
			if(!test(h.getHeap(), 1)){
				throw new Exception("HEAP ARRAY MISCONFIGUED.");
			}
		}
		
		System.out.println("PASSED.");
		
	}

}
