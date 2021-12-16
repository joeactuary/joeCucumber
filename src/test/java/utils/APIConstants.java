package utils;

import io.restassured.RestAssured;

public class APIConstants {

    public static final String BASEURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI= BASEURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI= BASEURI+"/createEmployee.php";
    public static final String GET_EMPLOYEE_URI= BASEURI+"/getOneEmployee.php";
    public static final String GET_JOBTITLES_URI= BASEURI+"/jobTitle.php";
    public static final String UPDATE_EMPLOYEE_URI= BASEURI+"/updateEmployee.php";
    public static final String UPDATE_PARTIALEMPLOYEE_URI= BASEURI+"/updatePartialEmplyeesDetails.php";
    public static final String DELETE_EMPLOYEE_URI= BASEURI+"/deleteEmployee.php";
    public static final String GET_ALLEMPLOYEES_URI= BASEURI+"/getAllEmployees.php";
    public static final String HEADER_CONTENT_TYPE= "Content-Type";
    public static final String CONTENT_TYPE= "application/json";
    public static final String HEADER_AUTHORIZATION= "Authorization";

}
