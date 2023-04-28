package testData;

import java.util.HashMap;
import java.util.Map;

public class AccountRegistration {

    public Map<String, Object> accountRegistration(String email, String firstName, String lastName, String ssn, Integer id) {

        Map<String, Object> accountRegistration = new HashMap<>();

        accountRegistration.put("email", email);
        accountRegistration.put("firstName", firstName);
        accountRegistration.put("lastName", lastName);
        accountRegistration.put("ssn", ssn);
        accountRegistration.put("id",id);

     return accountRegistration;
    }

    //ObjectMapper


}
