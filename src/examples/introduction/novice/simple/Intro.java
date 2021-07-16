package examples.introduction.novice.simple;

import static com.googlecode.cqengine.query.QueryFactory.contains;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;

import examples.introduction.novice.Person;

public class Intro {
    public static void main(String[] args) {
        // Create an indexed collection (note: could alternatively use CQEngine.copyFrom() existing collection)...
        IndexedCollection<Person> people = new ConcurrentIndexedCollection<Person>();

        // Add some indexes...
        people.addIndex(NavigableIndex.onAttribute(Person.NAME));

		// Add some objects to the collection...
        addData(people);

        // -------------------------- Run some queries --------------------------
        System.out.println("People whose names contain Arthur:");
        Query<Person> query1 = contains(Person.NAME, "Arthur");
        ResultSet results = people.retrieve(query1);
        results.forEach(System.out::println);
    }

	private static void addData(IndexedCollection<Person> people) {
		people.add(new Person("Arthur White"));
		people.add(new Person("Arthur Pendragon"));
		people.add(new Person("Arthur Bach"));
		people.add(new Person("Elizabeth I"));
		people.add(new Person("James I after Elizabeth I"));
	}
}
