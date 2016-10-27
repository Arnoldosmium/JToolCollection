/* Arnold Lin 12/24/2015
 * Multi-language Toolbox Java section
 * Heap actuallized by array list
 *  DONE:
 *    Fill in abstruct methods
 *    Improve by adding size of heap -> for heap sort
 */
package heap;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	private ArrayList<T> heap;
	protected int h_size;
	
	public ArrayHeap(){
		heap = new ArrayList<T>();
		heap.add(null);	
		h_size = 0;
	}
	
	public boolean isEmpty(){
		return h_size <= 0;
	}
	
	public int size(){
		return h_size;
	}
	
	public T[] getHeapArray(){
		return (T[]) Arrays.copyOfRange(heap.toArray(),1, heap.size()-2);
	}
	
	// #define getParentId(id)	id/2
	
	/**
	 * Swims the newly added, leftmost leaf up to correct position
	 */
	protected void swim(int k){
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
	protected void sink(int myid){
		T leaf = heap.get(myid);
		int childid;
		while((childid = myid*2) <= h_size){
			if(childid < h_size){	// Equivlent to childid+1 <= h_size
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
		swim(++h_size);
	}

	@Override
	public T removeMax() {
		T rmv = peek();
		heap.set(1, heap.get(h_size));
		heap.remove(h_size--);
		if(!isEmpty())
			sink(1);
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
