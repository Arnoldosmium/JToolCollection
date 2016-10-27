/* Arnold Lin 12/26/2015
 * Multi-language Toolbox Java section
 * Sort Tester
 *  DONE:
 *   Piecewise sort
 *   Full sort
 */

package sort;

import java.util.*;
import static org.junit.Assert.*;
import search.BinSearch;

public class SortTester {

	public static void main(String[] args) {
		int N = 100000;
		int range = 101010;
		int p_size = N/10;

		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> org = new ArrayList<Integer>();
		AbstractSort<Integer> s = new ShellSort<Integer>();
		BinSearch<Integer> bs = new BinSearch<Integer>();
		
		for(int i = 0; i < N; i++){
			int num;
			arr.add( num = r.nextInt(range));
			org.add( num );
		}
		
		System.out.println("Start with: "+org);
		
		//Piecewise sort test
		for(int base = 0; base <= (N-1)/p_size; base++){
			int bound = Math.min(N, (base+1) * p_size);
			s.sort(arr, base*p_size, bound);
			System.out.println("PIECEWISE SORT "+(base+1)+":"+arr);
			for(int i = base*p_size+1; i < bound; i++){
				assertTrue(arr.get(i).compareTo( arr.get(i-1) ) >= 0);
			}
			System.out.println("PASSED.");
		}
		
		s.sort(arr);

		System.out.println("SORT RESULT: " + arr);
		
		for(int i = 1; i < arr.size(); i++){
			assertTrue(arr.get(i).compareTo( arr.get(i-1) ) >= 0);
		}
		
		for(Integer i : org){
			assertTrue(bs.search(arr, i) >= 0);
		}
		
		System.out.println("NO DROPPED ITEM. PASSED.");
	}

}
