package examples.introduction.join.threeway;


import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;


public class Address {
    public final String city;
    public final int addressId;

    public Address(int id, String city) {
    	this.addressId=id;
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Address{id="+ addressId + ", city=" + city + "}";
    }
    
    // -------------------------- Attributes --------------------------
    public static final Attribute<Address, String> CITY = new City("city");
    // following is the compact version 
    public static final Attribute<Address, Integer> ADDRESS_ID =  new SimpleAttribute<Address, Integer>() {
        public Integer getValue(Address address, QueryOptions queryOptions) { return address.addressId; }
    };    
}
