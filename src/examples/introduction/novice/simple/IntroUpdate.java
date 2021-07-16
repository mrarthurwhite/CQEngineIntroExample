package examples.introduction.novice.simple;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;
import com.googlecode.cqengine.resultset.filter.DeduplicatingResultSet;

import static com.googlecode.cqengine.query.QueryFactory.*;


import examples.data.seed.LoadData;
import examples.models.Person;

public class IntroUpdate {

    public static void main(String[] args) {
        // Create an indexed collection (note: could alternatively use CQEngine.copyFrom() existing collection)...
        IndexedCollection<Person> people = new ConcurrentIndexedCollection<Person>();

        // Add some indexes...
        people.addIndex(NavigableIndex.onAttribute(Person.NAME));

		// Add some objects to the collection...
        LoadData.addData(people);

        // -------------------------- Run some queries --------------------------
        // Update the name of the Person  with name Arthur White, by replacing it using MVCC...
        Person newName = new Person("Arthur Whiter"); // Create a new name, different version
        people.add(newName); // Collection now contains two versions of the same person

        // Test the retrieval (collection contains both versions, should retrieve only one of them)...
        System.out.println("Prior to removal of old name: ");
        people.forEach(p -> {System.out.println("old:" + p);});

        Query<Person> query = equal(Person.NAME, "Arthur White");
        Person oldName = people.retrieve(query).uniqueResult(); // Retrieve the existing version
        people.remove(oldName); // Remove the old version, collection now only contains new version

        // Test the retrieval...
        System.out.println("After removal of old name: ");
        people.forEach(p -> {System.out.println("new: " + p);});

    }
    

    
    
}
