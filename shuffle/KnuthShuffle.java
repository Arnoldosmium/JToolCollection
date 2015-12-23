package shuffle;
/* Arnold Lin 12/22/2015
 * Multi-language Toolbox Java section
 * Knuth Shuffle Algorithm
 *  DONE:
 *    Finish Abstract Shuffle x2
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class KnuthShuffle<T extends Comparable<T>> extends Shuffler<T>{

	@Override
	//In place Shuffle
	protected void shuffle(List<T> list) {
		for(int i = 0; i < list.size()-2; i++){
			int j = super.r.nextInt(list.size()-i) + i;
			T swap = list.get(i);
			list.set(i, list.get(j));
			list.set(j, swap);
		}
	}
	
	//Original list remains unchanged
	protected List<T> newListShuffle(List<T> list){
		List<T> rtn = new ArrayList<T>();
		for(T key: list)
			rtn.add(key);
		shuffle(rtn);
		return rtn;
	}
	
}
