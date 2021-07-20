package examples.introduction.novice.simpler.model;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class Name<O, A> extends SimpleAttribute<O, A> {



	public Name(String attributeName) {
		super(attributeName);
		// TODO Auto-generated constructor stub
	}

	public String getValue(Person person, QueryOptions queryOptions) { return person.name; }

	@Override
	public A getValue(O arg0, QueryOptions arg1) {
		// TODO Auto-generated method stub
		return null;
	}


}
	
