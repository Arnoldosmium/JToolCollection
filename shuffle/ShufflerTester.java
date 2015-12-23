/* Arnold Lin 12/23/2015
 * Multi-language Toolbox Java section
 * Shuffler Tests
 * <DONE>
 */

package shuffle;

import java.util.*;


public class ShufflerTester {

	public static void main(String[] args) throws Exception {
		int N = 10;
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		ArrayList<Integer> src = new ArrayList<Integer>();
		for(int i = 0; i < N; i++){
			list.add(i);
			src.add(i);
		}
		
		// Any Lost Element?
		Shuffler<Integer> shf = new KnuthShuffle<Integer>();
		shf.shuffle(list);
		setEquals(src, list);
		
		// Set Source Test, get copy test.
		shf.setSrc(list);
		setEquals(src, shf.getShuffleCopy());

		// Set random seed test.
		long seed = new Random().nextLong();
		shf.setSrc(src);
		shf.setSeed(seed);
		list = (ArrayList<Integer>)shf.getShuffleCopy();
		shf.setSrc(src);
		src = list;
		shf.setSeed(seed);
		list = (ArrayList<Integer>)shf.getShuffleCopy();
		for(int i = 0; i < src.size(); i++){
			if(!src.get(i).equals(list.get(i)))
				throw new Exception("Different Random list @ "+i);
		}
		
		System.out.println("PASSED.");
	}
	
	public static void setEquals(ArrayList<Integer> src, List<Integer> dest) throws Exception{
		for(Integer i : src){
			if(dest.indexOf(i) < 0)
				throw new Exception("Destination lost element "+i);
		}
	}

}
