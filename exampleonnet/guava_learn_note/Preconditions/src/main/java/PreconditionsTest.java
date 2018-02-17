import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.base.Preconditions;

public class PreconditionsTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void Preconditions1() {
		getPersonByPrecondition(8, "peida");
	}
	
	@Test
	public void Preconditions2() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("age 必须大于0");
		getPersonByPrecondition(-9, "peida");
	}
	
	@Test
	public void Preconditions3() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("neme为\'\'");
		getPersonByPrecondition(8, "");
	}
	
	@Test
	public void Preconditions4() {
		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("neme为null");
		getPersonByPrecondition(8, null);
	}

	private void getPersonByPrecondition(int age, String neme) {
		Preconditions.checkNotNull(neme, "neme为null");
		Preconditions.checkArgument(neme.length() > 0, "neme为\'\'");
		Preconditions.checkArgument(age > 0, "age 必须大于0");
		System.out.println("a person age:" + age + ",neme:" + neme);
	}

	@Test
	public void Preconditions_checkState() {
		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("intList size 不能大于");
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
	}

	private void checkState(List<Integer> intList, int index) {
		// 表达式为true不抛异常
		Preconditions.checkState(intList.size() < index, " intList size 不能大于" + index);
	}
	
	
	@Test
	public void Preconditions_checkPositionIndex() {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
		checkPositionIndex(intList,3);    
		
		expectedEx.expect(IndexOutOfBoundsException.class);
		expectedEx.expectMessage(" 不在 list中， List size为：");
		
		checkPositionIndex(intList,13);    
	}

	private void checkPositionIndex(List<Integer> intList, int index) {
		Preconditions.checkPositionIndex(index, intList.size(), "index " + index + " 不在 list中， List size为：" + intList.size());
	}
	
	
	@Test
	public void Preconditions_checkPositionIndexes() {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
		checkPositionIndexes(intList,3,7);
		
		expectedEx.expect(IndexOutOfBoundsException.class);
		checkPositionIndexes(intList,3,17);
	}
	
	@Test
	public void Preconditions_checkPositionIndexes2() {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
		
		expectedEx.expect(IndexOutOfBoundsException.class);
		checkPositionIndexes(intList,13,17);
	}
	
	private void checkPositionIndexes(List<Integer> intList, int start, int end) {
		Preconditions.checkPositionIndexes(start, end, intList.size());
	}
	
	@Test
	public void Preconditions_checkElementIndex() {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
		
		expectedEx.expect(IndexOutOfBoundsException.class);
		checkElementIndex(intList, 6);
	}
	
	@Test
	public void Preconditions_checkElementIndex2() {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			checkState(intList, 9);
			intList.add(i);
		}
		
		expectedEx.expect(IndexOutOfBoundsException.class);
		checkElementIndex(intList, 16);
	}

	private void checkElementIndex(List<Integer> intList, int index) {
		Preconditions.checkElementIndex(index, intList.size(), "index 为 " + index + " 不在 list中， List size为： " + intList.size());
	}
}
