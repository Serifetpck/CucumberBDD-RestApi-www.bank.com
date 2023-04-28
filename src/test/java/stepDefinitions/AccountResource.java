package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testData.AccountTestData;
import utils.ReusableMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utils.Authentication.generateToken;


public class AccountResource {
    String url;

    Response response;

    @When("Set the URL")
    public void setTheURLAccond() {
        url = ReusableMethods.gmiBankUrlSetup("/api/account");

    }

    @And("Type code to send request -accound")
    public void typeCodeToSendRequestAccound() {
        response = given().headers("Authorization", "Bearer " + generateToken()).when().get(url);
        response.prettyPrint();
    }

    @And("Do Assertion-accound")
    public void doAssertionAccound() {
        ////Matchers class kullanarak assertion yapma
        response.then().
                body("id", equalTo(163125),
                        "login", equalTo("batch81"),
                        "firstName", equalTo("eyup"),
                        "lastName", equalTo("bas"),
                        "email", equalTo("dddda@gmail.com"));
    }


    @When("Set the URL-register")
    public void setTheURLRegister() {
        url=ReusableMethods.gmiBankUrlSetup("/api/register");
    }
    @And("Type code to send request -register")
    public void typeCodeToSendRequestRegister() {

        AccountTestData accountTestData=new AccountTestData("serarrm@gmail.com","metehan","cant","560-85-1469","5678439876","Serife.78","userrr");
        response=given().headers("Authorization", "Bearer " + generateToken()).
                contentType(ContentType.JSON).body(accountTestData).when().post(url);



        response.prettyPrint();

        System.out.println(accountTestData.toString());


    }

    @And("Do Assertion-register")
    public void doAssertionRegister() {
        response.then().statusCode(201).body("email",equalTo("serarrm@gmail.com"));
        System.out.println(response.getStatusCode());
    }


}
