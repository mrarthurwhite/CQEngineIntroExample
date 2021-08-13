/**
 * 
 */
package examples.introduction.join.threeway;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

/**
 * @author SOLON
 *
 */
public class City extends SimpleAttribute<Address, String> {

    public City(String attributeName) {
        super(attributeName);
    }

    @Override
    public String getValue(Address address, QueryOptions queryOptions) { return address.city; }



}
