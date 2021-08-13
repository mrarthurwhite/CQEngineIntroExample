package examples.introduction.join.twoway;


import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;


public class Address {
    public final String city;
    
    public Address(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Address{city=" + city +"}";
    }
    
    // TODO: Simplify
    // -------------------------- Attributes --------------------------
    public static final Attribute<Address, String> CITY = new City("city");
    
}
