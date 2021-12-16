package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String empFirstName = "Abel";
    public static String empLastName = "Shlemkin";
    public static String empMiddleName = "Kputz";
    public static String empGender = "M";
    public static String empBirthday = "2072-12-06";
    public static String empStatus = "Employee";
    public static String empJobTitle = "API Tester";

    public static String createEmployeePayload(){

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Abel\",\n" +
                "  \"emp_lastname\": \"Shlemkin\",\n" +
                "  \"emp_middle_name\": \"Kputz\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2072-12-06\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"API Tester\"\n" +
                "}";

                return createEmployeePayload;
    }

    public static String createEmployeeBody() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", empFirstName);
        obj.put("emp_lastname", empLastName);
        obj.put("emp_middle_name", empMiddleName);
        obj.put("emp_gender", empGender);
        obj.put("emp_birthday", empBirthday);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", empJobTitle);
        return obj.toString();
    }

    public static String createEmployeeBody(String empFirstName, String empLastName, String empMiddleName, String empGender,String empBirthday,
                                            String empStatus,String empJobTitle) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", empFirstName);
        obj.put("emp_lastname", empLastName);
        obj.put("emp_middle_name", empMiddleName);
        obj.put("emp_gender", empGender);
        obj.put("emp_birthday", empBirthday);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", empJobTitle);
        return obj.toString();
    }


}
