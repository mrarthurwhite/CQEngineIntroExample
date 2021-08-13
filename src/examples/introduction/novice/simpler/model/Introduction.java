package examples.introduction.novice.simpler.model;
import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import static com.googlecode.cqengine.query.QueryFactory.*;
/**
 *TODO: NOT WORKING!
 * This gives the following error:
 * Exception in thread "main" java.lang.ExceptionInInitializerError
	at examples.introduction.novice.simpler.model.Introduction.main(Introduction.java:17)
Caused by: java.lang.IllegalStateException: Attribute 'name' (class examples.introduction.novice.simpler.model.Name) is invalid, cannot read generic type information from it. Attributes should typically EITHER be declared in code with generic type information as a (possibly anonymous) subclass of one of the provided attribute types, OR you can use a constructor of the attribute which allows the types to be specified manually.
	at com.googlecode.cqengine.attribute.support.AbstractAttribute.readGenericObjectType(AbstractAttribute.java:139)
	at com.googlecode.cqengine.attribute.support.AbstractAttribute.<init>(AbstractAttribute.java:43)
	at com.googlecode.cqengine.attribute.SimpleAttribute.<init>(SimpleAttribute.java:55)
	at examples.introduction.novice.simpler.model.Name.<init>(Name.java:11)
	at examples.introduction.novice.simpler.model.Person.<clinit>(Person.java:23)
	... 1 more
 */
public class Introduction {

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
        people.retrieve(query1).forEach(System.out::println);
    }

	private static void addData(IndexedCollection<Person> people) {
		people.add(new Person("Arthur White"));
		people.add(new Person("Arthur Pendragon"));
		people.add(new Person("Arthur Bach"));
		people.add(new Person("Elizabeth I"));
		people.add(new Person("James I after Elizabeth I"));
	}
}
