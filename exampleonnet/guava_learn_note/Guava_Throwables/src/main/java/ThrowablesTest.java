import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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

	public void throwIfInstanceOf() throws IOException {
		try {
			throw new IOException("测试IOException");
		} catch (Throwable t) {
			// Throwables.propagateIfInstanceOf(t, IOException.class);
			// throw Throwables.propagate(t);

			Throwables.throwIfInstanceOf(t, IOException.class);
			throw new AssertionError(t);
		}
	}

	public void testCheckException() {
		try {
			URL url = new URL("http://ociweb.com"); // 会抛出IOException
			final InputStream in = url.openStream();
			// read from the input stream
			in.close();
		} catch (Throwable t) {
			// Throwables.throwIfInstanceOf(t, IOException.class);
			Throwables.throwIfUnchecked(t);
			throw new AssertionError(t);
		}
	}

	@Test
	public void test() {
		try {
			throwIfInstanceOf();
			System.out.println("没捕获到异常");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
