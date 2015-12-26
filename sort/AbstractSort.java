/* Arnold Lin 12/26/2015
 * Multi-language Toolbox Java section
 * Abstract class: Sort
 * 
 */
package sort;

import java.util.List;

public abstract class AbstractSort<T extends Comparable<T>> {
	
	//Sort all
	abstract public void sort(List<T> list);
	
	//Partially sort, sort index range [from, to)
	abstract public void sort(List<T> list, int from, int to); 

}
