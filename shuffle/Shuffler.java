/* Arnold Lin 12/22/2015
 * Multi-language Toolbox Java section
 * Shuffle Interface
 *  DONE:
 *    Abstract Shuffle
 *    Seed selectable
 *    Source selectable
 */
package shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Shuffler<T extends Comparable<T>>{
	protected Random r;
	private List<T> src;
	private long seed;
	
	public void setSeed(long seed){
		this.r = new Random(this.seed = seed);
	}
	
	public void setSrc(List<T> source){
		if(source != null){
			src = new ArrayList<T>();
			for(T key: source)
				src.add(key);
		}
	}
	
	public Shuffler(){
		r = new Random();
		src = null;
		seed = -1;
	}
		
	abstract protected void shuffle(List<T> list);
	
	abstract protected List<T> newListShuffle(List<T> list);
	
	public List<T> getList(){
		return src;
	}
	
	public List<T> getShuffle(List<T> list){
		if(list == null)
			throw new NullPointerException("Trying to shuffle an null pointer");
		shuffle(list);
		return list;
	}
	
	public List<T> getShuffle(){
		if(src == null)
			throw new NullPointerException("Trying to shuffle null source pointer");
		return getShuffle(src);
	}
	
	public List<T> getShuffleCopy(List<T> list){
		if(list == null)
			throw new NullPointerException("Trying to shuffle an null pointer");
		return newListShuffle(list);
	}
	
	public List<T> getShuffleCopy(){
		if(src == null)
			throw new NullPointerException("Trying to shuffle null source pointer");
		return getShuffleCopy(src);
	}
		
}
