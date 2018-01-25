import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BiMapTestCase {

	@Test
	public void BimapTest1() {
		BiMap<Integer, String> logfileMap = HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");

		System.out.println(logfileMap);
		
		assertThat(1, greaterThan(50));
	}
}
