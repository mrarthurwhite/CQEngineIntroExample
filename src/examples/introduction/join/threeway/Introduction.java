package examples.introduction.join.threeway;
import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import static com.googlecode.cqengine.query.QueryFactory.*;
/**

 */
public class Introduction {
    // The Person<-->> Person_Address <<--> Address

    public static void main(String[] args) {
        // Create an indexed collection ...
        IndexedCollection<Person> people = new ConcurrentIndexedCollection<Person>();
        addPeople(people);	// Add some people to the collection...

        // Create an indexed collection of addresses...
        IndexedCollection<Address> locations = new ConcurrentIndexedCollection<Address>();
        addLocations(locations);

        // The Person<-->> Person_Address <<--> Address
        IndexedCollection<PersonAddress> personAddress = new ConcurrentIndexedCollection<PersonAddress>();
        addPeopleToLocations(personAddress);
        
        // -------------------------- Run some queries --------------------------

        // Retrieve people located in London...
        Query<Person> peopleInLondon =
                existsIn(personAddress, Person.PERSON_ID, PersonAddress.PERSON_ID,
                        existsIn(locations, PersonAddress.ADDRESS_ID, Address.ADDRESS_ID, equal(Address.CITY, "London, U.K.")));

        for (Person p : people.retrieve(peopleInLondon)) {
            System.out.println(p.name);
            /*
             * Prints: 
             * Elizabeth I
             * Arthur Pendragon
             * */
        }
     
    }

	private static void addPeople(IndexedCollection<Person> people) {
		people.add(new Person(1, "Arthur White"));
		people.add(new Person(2, "Arthur Pendragon"));
		people.add(new Person(3, "Elizabeth I"));
	}
	
	private static void addLocations(IndexedCollection<Address> locations) {
		locations.add(new Address(1, "Edinburgh, U.K."));
		locations.add(new Address(2, "London, U.K."));
	}
	
	private static void addPeopleToLocations(IndexedCollection<PersonAddress> personAddress) {
		personAddress.add(new PersonAddress(1, 1));
		personAddress.add(new PersonAddress(2, 2));
		personAddress.add(new PersonAddress(3, 2));
	}
}
