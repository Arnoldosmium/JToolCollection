/* Arnold Lin 10/27/2016
 * Multi-language Toolbox Java section
 * Tuple Tester
 */
package tuple;

public class TupleTester {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// Empty tuples
		System.out.println(compareToString(new Tuple(), new Tuple()));
		Tuple<Integer> t0;
		// (1, 2, 3, 5) > (1, 2, 3, 4)
		System.out.println(compareToString(t0 = new Tuple<Integer>(1, 2, 3, 5), new Tuple<Integer>(1, 2, 3, 4)));
		// Passing Arrays
		Tuple<String> t1;
		System.out.println(compareToString(new Tuple<String>("Tuple Tester".split(" +")),
				new Tuple<String>("Tuple  Tester".split(" +"))));
		System.out.println(compareToString(new Tuple<String>("Tuple Tester".split(" ")),
				t1 = new Tuple<String>("Tuple  Tester".split(" "))));
		// Get Anyway
		Object o = t1.getAnyway(-1);
		System.out.println(o.getClass().toString() + " -> " + o.toString());
		// Concatination
		Tuple sum = t1.concat(t0);
		System.out.println(sum);
		o = sum.getAnyway(-1);
		System.out.println(o.getClass().toString() + " -> " + o.toString());
		
	}
	
	static <T extends Comparable<T>> String compareToString(T a, T b){
		int rst = a.compareTo(b); 
		return a.toString() + " " +  (rst > 0 ? ">" : (rst < 0 ? "<" : "==")) + " " + b.toString();
	}


}
