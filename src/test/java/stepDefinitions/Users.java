package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utility.DateUtility.removeTime;

public class Users {
    private Response response;
    private JSONObject requestBody;

    @Given("I set the base URL for the ReqRes API")
    public void iSetTheBaseURLForTheReqResAPI() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("I send a POST request to create a user with name {string} and job {string}")
    public void iSendAPostRequestToCreateAUserWithNameAndJob(String name, String job) {
        requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job", job);

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post("/users");
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int expectedStatusCode) {
        assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Then("the response body should contain the name {string}")
    public void theResponseBodyShouldContainTheName(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        assertEquals(actualName, expectedName);
    }

    @Then("the response body should contain the job {string}")
    public void theResponseBodyShouldContainTheJob(String expectedJob) {
        String actualJob = response.jsonPath().getString("job");
        assertEquals(actualJob, expectedJob);
    }

    @When("I send get request to retrieve a user with id {int}")
    public void iSendGetRequestToRetrieveAUserWithId(int id) {
        response = given()
                .get("/users/" + id);
    }

    @Then("the response body should contain the email {string}")
    public void theResponseBodyShouldContainTheEmail(String expectedEmail) {
        String actualEmail = response.jsonPath().getString("data.email");
        assertEquals(actualEmail, expectedEmail);
    }

    @Then("the response body should contain the first name {string}")
    public void theResponseBodyShouldContainTheFirstName(String expectedFirstName) {
        String actualFirstName = response.jsonPath().getString("data.first_name");
        assertEquals(actualFirstName, expectedFirstName);
    }

    @Then("the response body should contain the last name {string}")
    public void theResponseBodyShouldContainTheLastName(String expectedLastName) {
        String actualLastName = response.jsonPath().getString("data.last_name");
        assertEquals(actualLastName, expectedLastName);
    }

    @When("I send patch request to update a user with id {int}")
    public void iSendPatchRequestToUpdateAUserWithId(int id) {
        response = given()
                .put("/users/" + id);
    }

    @Then("the response body should contain current date")
    public void theResponseBodyShouldContainTheCurrentDate() throws ParseException {
        String actualUpdatedAtString = response.jsonPath().getString("updatedAt");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date actualDate = formatter.parse(actualUpdatedAtString);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/London")); // reqres.in timezone
        Date currentDate = calendar.getTime();

        assertEquals(removeTime(actualDate), removeTime(currentDate));
    }

    @When("I send patch request to delete a user with id {int}")
    public void iSendPatchRequestToDeketeAUserWithId(int id) {
        response = given()
                .delete("/users/" + id);
    }

}
