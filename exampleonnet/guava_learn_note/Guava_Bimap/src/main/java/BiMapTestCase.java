import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.hamcrest.core.IsNot;

public class BiMapTestCase {

	@Test
	public void BimapTest() {
		BiMap<Integer, String> logfileMap = HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");

		BiMap<String, Integer> filelogMap = logfileMap.inverse();

		BiMap<String, Integer> matcherMap = logfileMap.inverse();
		matcherMap.put("a.log", 1);
		matcherMap.put("b.log", 2);
		matcherMap.put("c.log", 3);

		assertThat(filelogMap, is(matcherMap));
	}

	@Test(expected=IllegalArgumentException.class)
	public void BimapTest1() {
		BiMap<Integer, String> logfileMap = HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
		logfileMap.put(4, "d.log");
		logfileMap.put(5, "d.log");
	}
	
	@Test
	public void BimapTest2() {
		BiMap<Integer,String> logfileMap = HashBiMap.create();
		logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log"); 
        logfileMap.put(4,"d.log"); 
        logfileMap.forcePut(5,"d.log"); 
        
        assertThat(logfileMap, hasEntry(5, "d.log"));
        assertThat(logfileMap, is(not(hasEntry(4, "d.log"))));
        assertThat(logfileMap, is(not(hasEntry(5, "d.log"))));
	}
}












