package examples.introduction.join.threeway;


import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;


public class Person {
    public final String name;
    public final int personId;

    public Person(int id, String name) {
    	this.personId=id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{id="+ personId + ", name=" + name + "}";
    }
    
    // -------------------------- Attributes --------------------------
    public static final Attribute<Person, String> NAME = new Name("name");
    // following is the compact version 
    public static final Attribute<Person, Integer> PERSON_ID =  new SimpleAttribute<Person, Integer>() {
        public Integer getValue(Person person, QueryOptions queryOptions) { return person.personId; }
    };
    
}
