/**
 * 
 */
package examples.introduction.join.threeway;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

/**
 * @author SOLON
 *
 */
public class PersonAddress {
    public final int personId;
    public final int addressId;
    
	public PersonAddress(int personId, int addressId) {
		this.personId = personId;
		this.addressId = addressId;
	}

    // -------------------------- Attributes --------------------------
    public static final Attribute<PersonAddress, Integer> PERSON_ID =  new SimpleAttribute<PersonAddress, Integer>() {
        public Integer getValue(PersonAddress personAddress, QueryOptions queryOptions) { return personAddress.personId; }
    };
    public static final Attribute<PersonAddress, Integer> ADDRESS_ID =  new SimpleAttribute<PersonAddress, Integer>() {
        public Integer getValue(PersonAddress personAddress, QueryOptions queryOptions) { return personAddress.addressId; }
    };  
	
}
