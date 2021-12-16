package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("token is generated")
    public void token_is_generated() {

        RequestSpecification requestSpecification = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"Lefkin2@crud.com\",\n" +
                        "  \"password\": \"password\"\n" +
                        "}");

            Response response = requestSpecification.when().post("/generateToken.php");


        response.prettyPrint();

           token = "Bearer " + response.jsonPath().getString("token");
            System.out.println("New Token is:    " + token);

            response.then().assertThat().statusCode(200);

            System.out.println(response.header("Date"));
        }





}
