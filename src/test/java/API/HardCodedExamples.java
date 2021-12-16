package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {


    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzkxNzY1MDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzOTIxOTcwMCwidXNlcklkIjoiMzM1MyJ9.k7QSi2bVsPBgsuYeo8Eb08I0qnvfMBtQ7Gw_dFI2iLg";
    static String employee_id = "25651A";

    @Test
    public void atoken_is_generated() {

        RequestSpecification requestSpecification = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"Lefkin2@crud.com\",\n" +
                        "  \"password\": \"password\"\n" +
                        "}");

        Response response = requestSpecification.when().post("/generateToken.php");


        response.prettyPrint();

        token = "Bearer " + response.jsonPath().getString("token");
        String dateOfToken = response.header("Date");

        System.out.println("New Token is:    " + token);

        response.then().assertThat().statusCode(200);

        System.out.println(response.header("Date"));
    }

    @Test
    public void bcreateEmployee() {
        RequestSpecification requestSpecification = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Abel\",\n" +
                        "  \"emp_lastname\": \"Shlemkin\",\n" +
                        "  \"emp_middle_name\": \"middle\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2072-12-06\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"API Tester\"\n" +
                        "}");

        Response response = requestSpecification.when().post("/createEmployee.php");

        response.print();

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println("New Employee ID is:    " + employee_id);

        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

        response.then().assertThat().body("Employee.emp_firstname", equalTo("Abel"));
        System.out.println(response.header("Date"));
    }


    @Test
    public void cgetDetailsOfOneEmployee() {
        RequestSpecification requestSpecification = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        Response response = requestSpecification.when().get("/getOneEmployee.php");
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);
        String empID = response.jsonPath().getString("employee.employee_id");

        System.out.println(employee_id + "    " + empID);

        Assert.assertEquals(employee_id, empID);
    }

    @Test
    public void dupdateEmployee() {
        RequestSpecification requestSpecification = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Abel\",\n" +
                        "  \"emp_lastname\": \"Shlemkin2\",\n" +
                        "  \"emp_middle_name\": \"middle\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2072-12-06\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"API Tester\"\n" +
                        "}");

        Response response = requestSpecification.when().put("\n" +
                "/updateEmployee.php");
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void egetAllEmployees() {

        RequestSpecification requestSpecification = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json");
        Response response = requestSpecification.when().get("\n" +
                "/getAllEmployees.php");

     //   String allEmployees = response.prettyPrint();
     //   JsonPath jsonPath = new JsonPath(allEmployees);

        JsonPath jsonPath = response.jsonPath();
        int count = jsonPath.getInt("Employees.size()");

        for (int i=0; i < 25; i++) {

            String employeeIds = jsonPath.getString("Employees[" + i +"].employee_id");
            String joe = "y";
            String empID = response.jsonPath().getString("Employees[" + i +"].employee_id");
            System.out.println(employeeIds + "    "   + empID);
        }


            }




        }

