/* Arnold Lin 12/22/2015
 * Multi-language Toolbox Java section
 * Shuffle Algorithm with creating a new list
 *  DONE:
 *    Finish Abstract Shuffle x2
 */
package shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreationShuffle<T extends Comparable<T>> extends Shuffler<T> {

	@Override
	//Should never be used...
	//Low Efficiency
	protected void shuffle(List<T> list) {
		List<T> k = newListShuffle(list);
		list.clear();
		for(T elem: k)
			list.add(elem);
	}

	@Override
	//Creating a list with changing the original list
	protected List<T> newListShuffle(List<T> list) {
		List<T> rtn = new ArrayList<T>();
		for(int i = list.size()-1; i >=0; i--){
			int idx = super.r.nextInt(i+1);
			T pickup = list.get(idx); 
			rtn.add(pickup);
			list.set(idx, list.get(i));
			list.set(i, pickup);
		}
		return rtn;
	}

}
