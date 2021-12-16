package APISteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class APIWorkFlowSteps {

    RequestSpecification requestSpecification;
    Response response;
    public static String employee_id;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {

        requestSpecification = given()
                .header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.token)
                .header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .body(APIPayloadConstants.createEmployeePayload());
        System.out.println("REQUEST SPECIFICATION is:    " + requestSpecification);

        requestSpecification = given()
                .header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.token)
                .header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .body(APIPayloadConstants.createEmployeeBody());
    }

    @Given("a request is prepared for creating an employee {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void a_request_is_prepared_for_creating_an_employee(String string, String string2, String string3, String string4, String string5, String string6, String string7) {

        requestSpecification = given()
                .header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.token)
                .header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .body(APIPayloadConstants.createEmployeeBody(string,string2,string3,string4,string5,string6,string7));

    }



    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_and_employee() {
        response = requestSpecification.when().post(APIConstants.CREATE_EMPLOYEE_URI);
        response.print();
    }

    @Then("the status code is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statusCode) {

        response.then().assertThat().statusCode(statusCode);

        //  response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

    }

    @Then("the employee created contains key {string} and value {string}")
    public void the_employee_created_contains_key_and_value(String JsonTree, String expectedMessage) {

        response.then().assertThat().body(JsonTree, equalTo(expectedMessage));
    }

    @Then("the employee id {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_calls(String JsonTree) {

        employee_id = response.jsonPath().getString(JsonTree);
    }

    //        ***************************************************************************************************************


    @Given("a request is prepared for getting an employee")
    public void a_request_is_prepared_for_getting_an_employee() {
        requestSpecification = given()
                .header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.token)
                .header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .body(APIPayloadConstants.createEmployeePayload())
                .queryParam("employee_id",employee_id);

    }


    @When("a Get call is made to retrieve an employee")
    public void a_get_call_is_made_to_retrieve_an_employee() {

        response = requestSpecification.when().get(APIConstants.GET_EMPLOYEE_URI);
        response.print();


    }
    @And("the retrieved employee ID {string} matches the stored employee id")
    public void theRetrievedEmployeeIDMatchesTheStoredEmployeeId(String jsonTree) {

       response.then().assertThat().body(jsonTree, equalTo(employee_id));
        //                or
        Assert.assertEquals(response.jsonPath().getString(jsonTree), employee_id);
        Assert.assertEquals(response.body().jsonPath().getString(jsonTree), employee_id);
        String tempEmpId = response.jsonPath().getString(jsonTree);
            }


    @Then("the retrieved data at {string} object matches the data used to create an employee with employee id {string}")
    public void the_retrieved_data_at_object_matches_the_data_used_to_create_an_employee_with_employee_id
            (String employeeObject, String responseEmployeeID, DataTable dataTable) {

        List<Map<String,String>> expectedData = dataTable.asMaps();
                Map<String,String> actualData = response.body().jsonPath().get(employeeObject);

for (Map<String,String> expectedMap : expectedData) {
    Set<String> keys = expectedMap.keySet();
    for(String key : keys) {
        String expectedValue = expectedMap.get(key);
        String actualValue = actualData.get(key);
        System.out.println("Expected value =   " + expectedValue + "     Actual value     ="  + actualValue);
        Assert.assertEquals(expectedValue,actualValue);


    }



}







    }



}
