package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BankUrl {

    public static String gmiBankurl="https://www.gmibank.com";
    protected  RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    }
}
