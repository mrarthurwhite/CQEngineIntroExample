package examples.models;


import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;


public class Person {
    public final String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{name=" + name +"}";
    }
    
    // -------------------------- Attributes --------------------------
    public static final Attribute<Person, String> NAME = new SimpleAttribute<Person, String>("name") {
        public String getValue(Person person, QueryOptions queryOptions) { return person.name; }
    };

}
