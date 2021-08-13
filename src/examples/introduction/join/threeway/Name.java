package examples.introduction.join.threeway;

import com.googlecode.cqengine.attribute.SimpleAttribute;


import com.googlecode.cqengine.query.option.QueryOptions;
public class Name extends SimpleAttribute<Person, String> {
    public Name(String attributeName) {
        super(attributeName);
    }

    @Override
    public String getValue(Person person, QueryOptions queryOptions) { return person.name; }

}