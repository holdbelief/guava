import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.Callable;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CallableCacheTestCase {

	@Test
	public void testcallableCache() throws Exception {
		Cache<String, String> cache = 
				CacheBuilder.newBuilder()
				.maximumSize(1000).build();
		String resultVal = cache.get("jerry", new Callable<String>() {

			@Override
			public String call() throws Exception {
				String strProValue = "hello "+"jerry"+"!";            
				return strProValue;
			}
			
		});
		
		System.out.println("jerry value : " + resultVal);

		resultVal = cache.get("peida", new Callable<String>() {

			@Override
			public String call() throws Exception {
				String strProValue = "hello " + "peida" + "!";
				return strProValue;
			}

		});
		
		System.out.println("peida value : " + resultVal);
	}
	
	public static void main(String[] args) {
		Object object = new Object();
		String str = "aa";
		
		        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();  
		        PhantomReference<Object> phantomReference = new PhantomReference<>(object,referenceQueue);  
		        PhantomReference<Object> phantomReferenceStr = new PhantomReference<>(str,referenceQueue);  
//		        object = null;  
//		        str = null;  
//		        System.gc();  
		        System.out.println("after system.gc---phantomReference = " + phantomReference.get());  
		        System.out.print("after system.gc---phantomReferenceStr = " + phantomReferenceStr.get());  
	}
}





























