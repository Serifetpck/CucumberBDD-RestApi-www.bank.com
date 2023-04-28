package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Authentication.generateToken;

public class GetBankAccound {
    String url;
    Response response;
    @When("Set the URL-accounds")
    public void setTheURLAccound() {
        url="https://www.bank.com/api/tp-accounts";



    }

    @And("Type code to send request -accounds")
    public void typeCodeToSendRequestAccound() {

        response=given().headers("Authorization","Bearer " + generateToken()).when().get(url);
        response.prettyPrint();

    }

    @And("Do Assertion-accounds")
    public void doAssertionAccound() {
        //HTTP Status Code should be 200
        //  Content Type should be JSON
        response.then().statusCode(200).contentType(ContentType.JSON);
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("createDate"));

    }
}
