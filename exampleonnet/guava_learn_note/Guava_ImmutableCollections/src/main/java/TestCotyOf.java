import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class TestCotyOf {

	@Test
	public void testCotyOf() {
		ImmutableSet<String> imSet = ImmutableSet.of("peida", "jerry", "harry", "lisa");
		ImmutableList<String> imlist = ImmutableList.copyOf(imSet);
		ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSet);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(i + "x");
		}
		
		System.out.println("list："+list);
        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist："+imInfolist);
        int imInfolistSize=imInfolist.size();
        System.out.println("imInfolistSize："+imInfolistSize);
        ImmutableSet<String> imInfoSet=ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize-3));
        System.out.println("imInfoSet："+imInfoSet);
	}
}
