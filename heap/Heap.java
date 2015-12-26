/* Arnold Lin 12/26/2015
 * Multi-language Toolbox Java section
 * Heap Abstract class
 *  DONE:
 *    Basic add, remove, peek
 *  TODO: 
 *    Wrap up with other methods
 */

package heap;

public abstract class Heap<T extends Comparable<T>> {

	abstract public void add(T elem);
	abstract public T removeMax();
	abstract public T peek();
	abstract public boolean isEmpty();
	abstract public int size();
	
}
