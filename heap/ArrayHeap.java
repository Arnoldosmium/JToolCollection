/* Arnold Lin 12/23/2015
 * Multi-language Toolbox Java section
 * Heap actuallized by array list
 *  DONE:
 *    Fill in abstruct methods
 */
package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 * Heap Structure
 * 				L1
 * 		L2.1		 	L2.2
 * L3.1		L3.2	L3.3	L3.4
 * 
 * HEAP LIST:
 * NUL L1 L2.1 L2.2 L3.1 L3.2 L3.3 L3.4
 * 0	1	2	3	4	  5		6	7
 * 
 * Child: 1->2&3; 2->4&5; 3->6&7
 * 		N->2N, 2N+1
 * Parent: N -> N/2
 * 
 */

public class ArrayHeap<T extends Comparable<T>> extends Heap<T>{

	// Implementing Binary Heap
	
	ArrayList<T> heap;
	
	public ArrayHeap(){
		heap = new ArrayList<T>();
		heap.add(null);	
	}
	
	public boolean isEmpty(){
		return heap.size() <= 1;
	}
	
	// #define getParentId(id)	id/2
	
	/**
	 * Swims the newly added, leftmost leaf up to correct position
	 */
	protected void swim(){
		int k = heap.size()-1;
		T leaf = heap.get(k);
		T prt;
		while( (prt = heap.get(k / 2)) != null && leaf.compareTo(prt) > 0){
			heap.set(k, prt);
			k /= 2;
		}
		heap.set(k, leaf);
	}
		
	/**
	 * Sinks the root, replaced by rightmost leaf, down to correct position
	 */
	protected void sink(){
		T leaf = heap.get(1);
		int myid = 1;
		int childid;
		while((childid = myid*2) < heap.size()){
			if(childid+1 < heap.size()){
				childid += (heap.get(childid).compareTo(heap.get(childid+1)) > 0)? 0 : 1;
			}
			T largerChild;
			if(leaf.compareTo(largerChild = heap.get(childid)) > 0)
				break;
			heap.set(myid, largerChild);
			myid = childid;
		}
		heap.set(myid, leaf);
	}
	
	@Override
	public void add(T elem) {
		heap.add(elem);
		swim();
	}

	@Override
	public T removeMax() {
		T rmv = peek();
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		if(!isEmpty())
			sink();
		return rmv;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new NoSuchElementException("Heap is empty");
		return heap.get(1);
	}
	
	/**
	 * Designed for test
	 */
	public ArrayList<T> getHeap(){
		return heap;
	}
	
	
}
