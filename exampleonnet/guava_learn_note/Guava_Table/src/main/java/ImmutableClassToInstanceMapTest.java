import org.junit.Test;

import com.google.common.collect.ImmutableClassToInstanceMap;

public class ImmutableClassToInstanceMapTest {
	
	@Test(expected=UnsupportedOperationException.class)
	public void immutableClassToInstanceMapTest() {
		ImmutableClassToInstanceMap<Number> map = 
				new ImmutableClassToInstanceMap.Builder<Number>()
				.put(Integer.class, 100)
				.put(Float.class, 10.01f)
				.build();
		ImmutableClassToInstanceMap<Number> map2 = ImmutableClassToInstanceMap.copyOf(map);
		map.putInstance(Double.class, 12.09D);
	}
}
