package be.digitalcity.tu.pluralSightCourses.PS_Security.module2;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Person  implements Cloneable, Serializable {

	private static final Pattern ALLOWLIST = Pattern.compile("([A-Za-z'\\-])*");
	private final String name;
	private final Integer age;
	private final Collection<String> shirts;

	public Person(String name, Integer age, Collection<String> shirts) {
		if(age<13 || age>120) throw new IllegalArgumentException("invalid age");
		if(!ALLOWLIST.matcher(name).matches()) throw new IllegalArgumentException("invalid name");

		this.name = name;
		this.age = age;
		this.shirts = new ArrayList<>(shirts);
	}

	public Person(){
		this("default",15,Collections.emptyList());
	}

	public Person(String name, Integer age) {
		this(name,age, Collections.emptyList());

	}

	public Person(Person p) {
		this(p.name, p.age, p.shirts);
	}


	String getName() {
		return name;
	}

	Integer getAge() {
		return age;
	}

	Integer getShirtCount(){
		return shirts.size();
	}

	Iterator<String> getShirts(){
		return shirts.iterator();
	}

	Collection<String> getShirtCollection(){
		return Collections.unmodifiableCollection(this.shirts);
	}

	void addShirt(String shirt){
		shirts.add(shirt);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", shirts=" + shirts +
				'}';
	}

	@Override
	public Person clone() {
		return new Person(name,age,shirts);
	}

	private Object readResolve()throws ObjectStreamException{
		return new Person(this);
	}

}
