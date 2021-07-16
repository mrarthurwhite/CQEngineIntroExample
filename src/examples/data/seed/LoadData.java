package examples.data.seed;

import com.googlecode.cqengine.IndexedCollection;

import examples.models.Person;

public class LoadData {
	
	 public static void addData(IndexedCollection<Person> people) {
			people.add(new Person("Arthur White"));
			people.add(new Person("Arthur Pendragon"));
			people.add(new Person("Arthur Bach"));
			people.add(new Person("Elizabeth I"));
			people.add(new Person("James I after Elizabeth I"));
		}

}
