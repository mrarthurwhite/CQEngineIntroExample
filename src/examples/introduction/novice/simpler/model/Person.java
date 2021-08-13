package examples.introduction.novice.simpler.model;


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
    
    // TODO: Simplify
    // -------------------------- Attributes --------------------------
    public static final Attribute<Person, String> NAME = new Name("name");
    
}
