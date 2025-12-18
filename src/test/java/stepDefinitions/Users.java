package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Utility;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class Users {
    private Response response;
    private static final String ENDPOINT = "/users";

    @Given("I set the base URL for the ReqRes API")
    public void iSetTheBaseURLForTheReqResAPI() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("I send a POST request to create a user with name {string} and job {string}")
    public void iSendAPostRequestToCreateAUserWithNameAndJob(String name, String job) {
        Utility util = new Utility();
        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("job", job);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "reqres_c318e23f376c4bc99fd9c1c76d75e3e4");

        response = util.sendPostRequest(ENDPOINT, headers, body);
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
        Utility util = new Utility();
        String endpoint = ENDPOINT + "/" + id;

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "reqres_c318e23f376c4bc99fd9c1c76d75e3e4");

        response = util.sendGetRequest(endpoint, headers);
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
        Utility util = new Utility();
        String endpoint = ENDPOINT + "/" + id;

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "reqres_c318e23f376c4bc99fd9c1c76d75e3e4");

        Map<String, String> body = new HashMap<>();
        body.put("name", "abc");
        body.put("job", "DEF");

        response = util.sendPatchRequest(endpoint,headers,body);
    }

    @Then("the response body should contain current date")
    public void theResponseBodyShouldContainTheCurrentDate() throws ParseException {
        String actualUpdatedAtString = response.jsonPath().getString("updatedAt");

        LocalDate actualDateOnly = utilities.DateUtility.formatToLocalDate(actualUpdatedAtString);
        LocalDate londonDateOnly = utilities.DateUtility.tbilisiLocalDate();

        assertEquals(actualDateOnly, londonDateOnly);
    }

    @When("I send patch request to delete a user with id {int}")
    public void iSendPatchRequestToDeleteAUserWithId(int id) {
        Utility util = new Utility();
        String endpoint = ENDPOINT + "/" + id;

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "reqres_c318e23f376c4bc99fd9c1c76d75e3e4");

        response = util.sendDeleteRequest(endpoint,headers);
    }

}
