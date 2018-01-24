import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Throwables;

public class ThrowablesTest {

	public void testThrowables() {
		try {
			throw new Exception();
		} catch (Throwable t) {
			String ss = Throwables.getStackTraceAsString(t);
			System.out.println("ss:" + ss);
			// Throwables.propagate(t);
			Throwables.throwIfUnchecked(t);
		}
	}

	@Test
	public void call() throws IOException  {
		try {
			throw new IOException();
		} catch (Throwable t) {
//			Throwables.propagateIfInstanceOf(t, IOException.class);
//			throw Throwables.propagate(t);
			
			Throwables.throwIfInstanceOf(t, IOException.class);
			throw new AssertionError(t);
		}
	}
}
