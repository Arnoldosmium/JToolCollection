/* Arnold Lin 12/24/2015
 * Multi-language Toolbox Java section
 * Heap sort
 *  DONE
 */
package sort;

import java.util.List;

public class HeapSort<T extends Comparable<T>> extends AbstractSort<T>{
	
	private static int getParentID(int base, int myid){
		// 1st element at 1, returns id/2
		// 1st element at 0, returns (id+1)/2-1 = (id-1)/2
		// 1st element at base, returns (id-base-1)/2 + base
		if(myid == base)	return -1;
		return base + (myid-1-base)/2;
	}
	
	private static int getChildID(int base, int myid){
		// 1st element at 1, returns 2*id
		// 1st element at 0, returns 2*(id+1)-1 = 2*id+1
		// 1st element at base, returns base + 2*(id-base) + 1
		return base + 2*(myid - base) + 1;
	}
	
	private void sink(List<T> arr, int myid, int from, int to){
		//to is the upperbound, excluded, index to sort
		T leaf = arr.get(myid);
		int childid;
		while((childid = getChildID(from, myid)) < to){
			if(childid + 1 < to){	
				childid += (arr.get(childid).compareTo(arr.get(childid+1)) > 0)? 0 : 1;
			}
			T largerChild;
			if(leaf.compareTo(largerChild = arr.get(childid)) > 0)
				break;
			arr.set(myid,largerChild);
			myid = childid;
		}
		arr.set(myid,leaf);
	}
	
	@Override
	public void sort(List<T> arr, int from, int to) {
		// Heap-ize the array.
		// Sink all non-leaf
		int upBound = to-1;
		for(int i = getParentID(from, upBound); i >= from; i--){
				sink(arr, i, from, to);
		}
		
		while(upBound > from){
			T swap = arr.get(from);
			arr.set(from, arr.get(upBound));
			arr.set(upBound, swap);
			sink(arr, from, from, upBound--);
		}
	}

	@Override
	public void sort(List<T> list) {
		sort(list, 0, list.size());
	}

}
