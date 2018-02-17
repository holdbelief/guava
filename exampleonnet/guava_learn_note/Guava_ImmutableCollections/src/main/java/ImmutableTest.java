import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

public class ImmutableTest {

	@Test
	public void testJDKImmutable() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println(list);

		List<String> unmodifiableList = Collections.unmodifiableList(list);

		System.out.println(unmodifiableList);

		List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));

		System.out.println(unmodifiableList1);

		String temp = unmodifiableList.get(1);
		System.out.println("unmodifiableList [0]：" + temp);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after unmodifiableList:" + unmodifiableList);

		unmodifiableList1.add("bb");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);

		unmodifiableList.add("cc");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
	}

	@Test
	public void testGuavaImmutable() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		ImmutableList<String> imlist = ImmutableList.copyOf(list);

		list.add("baby");

		org.junit.Assert.assertEquals(list, Arrays.asList("a", "b", "c", "baby"));
		org.junit.Assert.assertEquals(imlist, Arrays.asList("a", "b", "c"));
	}

	@Test
	public void testGuavaImmutable2() {
		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		org.junit.Assert.assertEquals(imSortList, ImmutableSortedSet.of("a", "b", "c", "d"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGuavaImmutable3() {
		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
		imOflist.add("ki");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGuavaImmutable4() {
		ImmutableSet<Color> imColorSet = ImmutableSet.<Color>builder().add(new Color(0, 255, 255))
				.add(new Color(0, 191, 255)).build();
		
		imColorSet.add(new Color(1, 111, 255));
	}

}
