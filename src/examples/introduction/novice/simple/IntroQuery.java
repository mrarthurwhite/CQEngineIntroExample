package examples.introduction.novice.simple;

import static com.googlecode.cqengine.query.QueryFactory.contains;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;

import examples.models.Person;
import examples.data.seed.LoadData;

public class IntroQuery {
    public static void main(String[] args) {
        // Create an indexed collection (note: could alternatively use CQEngine.copyFrom() existing collection)...
        IndexedCollection<Person> people = new ConcurrentIndexedCollection<Person>();

        // Add some indexes...
        people.addIndex(NavigableIndex.onAttribute(Person.NAME));

		// Add some objects to the collection...
        LoadData.addData(people);

        // -------------------------- Run some queries --------------------------
        System.out.println("People whose names contain Arthur:");
        Query<Person> searchNames = contains(Person.NAME, "Arthur");
        ResultSet<Person> results = people.retrieve(searchNames);
        for (Person aperson : results) {
            System.out.println(aperson);
        }

    }


}
