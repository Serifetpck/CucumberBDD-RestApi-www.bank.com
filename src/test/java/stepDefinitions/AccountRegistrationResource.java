package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import testData.AccountRegistration;
import testData.AccountTestData;
import utils.ReusableMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Authentication.generateToken;

public class AccountRegistrationResource {

    String url;
   Response response;
   AccountRegistration accountRegistration;

    AccountTestData accountTestData;



    @When("Set the URL -resource")
    public void setTheURLResource() {




            url= ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations");




    }

    @And("Type code to send request -resource")
    public void typeCodeToSendRequestResource() {
       response= given().headers("Authorization","Bearer " +generateToken()).when().get(url);
       response.prettyPrint();
    }

    @And("Do Assertion-resource")
    public void doAssertionResource() {

        //List ile listeleme
      List<Integer> accountId=response.jsonPath().getList("id");
        System.out.println(accountId);
        List<Integer> accountName=response.jsonPath().getList("findAll{it.firstName=='seray'}.firstName");
        System.out.println(accountName);
        //hasItems-hasItem-hasSize-> -matchers
        response.then().body("firstName",hasItems("seray","metehan","Ali"));
        response.then().body("findAll{it.firstName=='seray'}.firstName",hasSize(8));

    }

    //Hesap Kayıt Olusturma post
    @When("Set the URL -post")
    public void setTheURLPost() {
        url= ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations");

    }

    @And("Type code to send request -post")
    public void typeCodeToSendRequestPost() {
      AccountRegistration obj=new AccountRegistration();
    Map<String,Object> expectedData= obj.accountRegistration("emsal@gmail.com","emsal","karaca","539-80-0773",179341);
      response= given().headers("Authorization","Bearer " +generateToken()).
              contentType(ContentType.JSON).body(expectedData).when().post(url);
      response.prettyPrint();
    }

    @And("Do Assertion-post")
    public void doAssertionPost() {
    List<String> check= response.jsonPath().getList("firstName");
      System.out.println(check);
    assertTrue(check.get(0).contains("emsal"));

        url= ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations/179341");

        response=given().headers("Authorization","Bearer " +generateToken()).when().delete(url);


    }
//Hesap Kayıdını Güncelleme(put)
    @When("Set the URL -GetAccountPut")
    public void setTheURLGetAccountPut() {
        url=ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations");
    }

    @And("Type code to send request -GetAccountPut")
    public void typeCodeToSendRequestGetAccountPut()  {
    accountTestData=new AccountTestData ("seray",0,"hare","567-76-9870");
     response= given().headers("Authorization","Bearer " + generateToken()).contentType(ContentType.JSON).body(accountTestData).when().put(url);
     response.prettyPrint();

    }

    @And("Do Assertion-GetAccountPut")
    public void doAssertionGetAccountPut() {

        Map<String, Object> actualData= response.as(HashMap.class);

      assertEquals(accountTestData.getFirstName(),actualData.get("firstName").toString());
      assertEquals(accountTestData.getLastName(),actualData.get("lastName").toString());
      assertEquals(accountTestData.getSsn(),actualData.get("ssn").toString());






        url= ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations/"+((Integer)actualData.get("id")));

        response=given().headers("Authorization","Bearer " +generateToken()).when().delete(url);




    }

    @When("Set the URL -AccountRegistrationsFind\\/\\{ssn}")
    public void setTheURLAccountRegistrationsFindSsn() {

        url=ReusableMethods.gmiBankUrlSetup("/api/tp-account-registrations/find/567-89-0773");
    }

    @And("Type code to send request -AccountRegistrationsFind\\/\\{ssn}")
    public void typeCodeToSendRequestAccountRegistrationsFindSsn() {

        accountRegistration=new AccountRegistration();
        accountRegistration.accountRegistration("deryaaaaaaaa@gmail.com","seray","simge","567-89-0773",179331);


    }

    @And("Do Assertion-AccountRegistrationsFind\\/\\{ssn}")
    public void doAssertionAccountRegistrationsFindSsn() {
    }
}
