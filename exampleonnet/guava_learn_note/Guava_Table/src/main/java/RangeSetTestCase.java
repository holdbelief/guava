import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetTestCase {
	
	@Test
	public void RangeTest() {
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10));
		System.out.println("1、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..10]]"));
		
		rangeSet.add(Range.closedOpen(11, 15));
		System.out.println("2、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..10], [11..15)]"));
		
		rangeSet.add(Range.open(15, 20));
		System.out.println("3、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..10], [11..15), (15..20)]"));
		
		rangeSet.add(Range.openClosed(0, 0)); 
		System.out.println("4、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..10], [11..15), (15..20)]"));
		
		rangeSet.remove(Range.open(5, 10)); 
		System.out.println("5、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..5], [10..10], [11..15), (15..20)]"));
		
		rangeSet.add(Range.closed(14, 16));
		System.out.println("6、" + rangeSet);
		assertThat(rangeSet.toString(), is("[[1..5], [10..10], [11..20)]"));
	
		RangeSet<Integer> complementRange = rangeSet.complement();
		System.out.println("7、" + complementRange);
		assertThat(complementRange.toString(), is("[(-∞..1), (5..10), (10..11), [20..+∞)]"));
		
		RangeSet<Integer> subRangeSet = rangeSet.subRangeSet(Range.closed(9, 15));
		System.out.println("8、" + subRangeSet);
		assertThat(subRangeSet.toString(), is("[[10..10], [11..15]]"));
		
		Set<Range<Integer>> set_range = rangeSet.asRanges();
		Iterator<Range<Integer>> iter = set_range.iterator();
		while ( iter.hasNext() ) {
			Range<Integer> r = iter.next();
			System.out.println("9、" + r);
		}
		
		set_range.forEach(new Consumer<Range<Integer>>() {
			@Override
			public void accept(Range<Integer> range) {
				System.out.println("10、" + range);
			}
		});
		
		
	}
}








