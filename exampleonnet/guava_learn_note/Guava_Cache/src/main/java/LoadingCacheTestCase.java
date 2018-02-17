import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LoadingCacheTestCase {
	@Test
	public void testLoadingCache() throws Exception {
		LoadingCache<String, String> cacheBuilder = 
				CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {

					@Override
					public String load(String key)  {
						String strProValue="hello "+key+"!";  
						return strProValue;
					}
					
				});
		
		assertThat(cacheBuilder.getUnchecked("jerry"), is("hello jerry!"));
		assertThat(cacheBuilder.get("peida"), is("hello peida!"));
		cacheBuilder.put("harry", "ssdded");
		assertThat(cacheBuilder.get("harry"), is("ssdded"));
	}
	
}
