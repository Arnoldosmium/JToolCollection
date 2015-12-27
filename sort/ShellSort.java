/* Arnold Lin 12/27/2015
 * Multi-language Toolbox Java section
 * Shell Sort in Knuth Sequence
 * 	Done
 */

package sort;

import java.util.List;

public class ShellSort<T extends Comparable<T>> extends AbstractSort<T>{
	
	protected static int getPrev(int term){
		return (term - 1)/3;
	}
	
	protected static int getStartTerm(int N){
		// Find the largest term < N/3
		// Faster if using dynamic method.
		int k_n = 1;
		int k_np1 = 4;
		while( k_np1 < N/3 ){
			k_n = k_np1;
			k_np1 = 3 * k_n+1;
		}
		return k_n;
	}
	
	@Override
	public void sort(List<T> list) {
		sort(list, 0, list.size());
	}

	@Override
	public void sort(List<T> list, int from, int to) {
		for(int step = getStartTerm(to-from); step > 0; step = getPrev(step)){
			for(int i = from+step; i < from+2*step; i++){
				//Do in-shell insertion
				for(int j = i; j < to; j += step){
					T elem = list.get(j);
					int id = j;
					while( (id -= step) >= from && elem.compareTo(list.get(id)) < 0){
						list.set(id+step, list.get(id));
					}
					list.set(id+step, elem);
				}
			}
		}
	}
}

