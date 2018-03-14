
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;

public class ObjectTest {
	@Test
	public void equalTest() {
		org.junit.Assert.assertTrue(Objects.equal("a", "a"));
		org.junit.Assert.assertFalse(Objects.equal("a", null));
		org.junit.Assert.assertTrue(Objects.equal(null, null));
	}

	@Test
	public void equalPersonTest() {
		org.junit.Assert.assertFalse(Objects.equal(new Person("peida", 23), new Person("peida", 23)));

		Person person = new Person("peida", 23);
		org.junit.Assert.assertTrue(Objects.equal(person, person));
	}

	@Test
	public void hashcodeTest() {
		System.out.println(Objects.hashCode("a"));
		System.out.println(Objects.hashCode("a"));
		System.out.println(Objects.hashCode("a", "b"));
		System.out.println(Objects.hashCode("b", "a"));
		System.out.println(Objects.hashCode("a", "b", "c"));

		Person person = new Person("peida", 23);
		System.out.println(Objects.hashCode(person));
		System.out.println(Objects.hashCode(person));
	}

	@Test
	public void toStringTest() {
		System.out.println(MoreObjects.toStringHelper(this).add("x", 1).toString());
		System.out.println(MoreObjects.toStringHelper(Person.class).add("x", 1).toString());

		Person person = new Person("peida", 23);
		String result = MoreObjects.toStringHelper(Person.class).add("name", person.name).add("age", person.age).toString();
		System.out.print(result);
	}

	class Person {
		public String name;
		public int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
