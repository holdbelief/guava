import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.primitives.Primitives;

public class ClassToInstanceMapTest {
	@Test
	public void classToInstanceMapTest() {
		ClassToInstanceMap<String> classToInstanceMapString = MutableClassToInstanceMap.create();
		classToInstanceMapString.putInstance(String.class, "peida");
		System.out.println(classToInstanceMapString.getInstance(String.class));
		assertThat(classToInstanceMapString.getInstance(String.class), is("peida"));
		
		ClassToInstanceMap<Person> classToInstanceMapPerson = MutableClassToInstanceMap.create();
		classToInstanceMapPerson.putInstance(Person.class, new Person("liming", 20));
		classToInstanceMapPerson.putInstance(SubPerson.class, new SubPerson("xiaoli", 17));
		assertThat(classToInstanceMapPerson.getInstance(Person.class), equalTo(new Person("liming", 20)));
		assertThat(classToInstanceMapPerson.getInstance(SubPerson.class), equalTo(new SubPerson("xiaoli", 17)));
		
//		Map<Class<? extends Person>, Person> m = new HashMap<>();
//		m.put(SubPerson.class, new SubPerson("xiaoli", 17));
		MutableClassToInstanceMap<Number> map = MutableClassToInstanceMap.create();
        map.putInstance(Integer.class, 100);
        map.putInstance(Float.class, 10.01f);
        System.out.println(map.getInstance(Integer.class));
        System.out.println(map.getInstance(Float.class));
        assertThat(map.getInstance(Integer.class), is(100));
		assertThat(map.getInstance(Float.class), is(10.01f));
	}
	
	public static void main(String[] args) {
		Object o = Primitives.wrap(Person.class).cast(new SubPerson("a", 1));
		System.out.println(o.getClass());
	}
}

class SubPerson extends Person {

	SubPerson(String name, int age) {
		super(name, age);
	}
}

class Person {
	public String name;
	public int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}