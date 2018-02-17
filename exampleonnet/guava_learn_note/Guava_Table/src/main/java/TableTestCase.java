import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTestCase {

	@Test
	public void TableTest() {
		Table<String, Integer, String> aTable = HashBasedTable.create();
		for (char a = 'A'; a <= 'C'; ++a) {
			for (Integer b = 1; b <= 3; ++b) {
				aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
			}
		}

		Table<String, Integer, String> thatTable = HashBasedTable.create();
		thatTable.put("A", 1, "A1");
		thatTable.put("A", 2, "A2");
		thatTable.put("A", 3, "A3");

		thatTable.put("B", 1, "B1");
		thatTable.put("B", 2, "B2");
		thatTable.put("B", 3, "B3");

		thatTable.put("C", 1, "C1");
		thatTable.put("C", 2, "C2");
		thatTable.put("C", 3, "C3");

		System.out.println(aTable);
		assertThat(thatTable, equalTo(thatTable));

		System.out.println(aTable.column(2));
		Map<String, String> thatColumn2 = new HashMap<>();
		thatColumn2.put("A", "A2");
		thatColumn2.put("B", "B2");
		thatColumn2.put("C", "C2");
		assertThat(aTable.column(2), equalTo(thatColumn2));

		System.out.println(aTable.row("B"));
		Map<Integer, String> thatRowB = new HashMap<>();
		thatRowB.put(1, "B1");
		thatRowB.put(2, "B2");
		thatRowB.put(3, "B3");
		assertThat(aTable.row("B"), equalTo(thatRowB));

		System.out.println(aTable.get("B", 2));
		assertThat(aTable.get("B", 2), is("B2"));
		
		System.out.println(aTable.contains("D", 1));   
		assertThat(aTable.contains("D", 1), is(false));
		
		System.out.println(aTable.containsColumn(3)); 
		assertThat(aTable.containsColumn(3), is(true));
		
		System.out.println(aTable.containsRow("C"));  
		assertThat(aTable.containsRow("C"), is(true));
		
		System.out.println(aTable.columnMap());
		Map<Integer, Map<String, String>> thatColumnMap = new HashMap<>();
		Map<String, String> col1Rows = new HashMap<>();
		col1Rows.put("A", "A1");
		col1Rows.put("B", "B1");
		col1Rows.put("C", "C1");
		thatColumnMap.put(1, col1Rows);
		
		Map<String, String> col2Rows = new HashMap<>();
		col2Rows.put("A", "A2");
		col2Rows.put("B", "B2");
		col2Rows.put("C", "C2");
		thatColumnMap.put(2, col2Rows);
		
		Map<String, String> col3Rows = new HashMap<>();
		col3Rows.put("A", "A3");
		col3Rows.put("B", "B3");
		col3Rows.put("C", "C3");
		thatColumnMap.put(3, col3Rows);
		
		assertThat(aTable.columnMap(), equalTo(thatColumnMap));
		
		
		System.out.println(aTable.rowMap());
		Map<String, Map<Integer, String>> thatRowMap = new HashMap<>();
		Map<Integer, String> row1Cols = new HashMap<>();
		row1Cols.put(1, "A1");
		row1Cols.put(2, "A2");
		row1Cols.put(3, "A3");
		thatRowMap.put("A", row1Cols);
		
		Map<Integer, String> row2Cols = new HashMap<>();
		row2Cols.put(1, "B1");
		row2Cols.put(2, "B2");
		row2Cols.put(3, "B3");
		thatRowMap.put("B", row2Cols);
		
		Map<Integer, String> row3Cols = new HashMap<>();
		row3Cols.put(1, "C1");
		row3Cols.put(2, "C2");
		row3Cols.put(3, "C3");
		thatRowMap.put("C", row3Cols);
		
		assertThat(aTable.rowMap(), equalTo(thatRowMap));
		
//		System.out.println(aTable.remove("B", 3)); 
		assertThat(aTable.remove("B", 3), equalTo("B3"));
	}
}
