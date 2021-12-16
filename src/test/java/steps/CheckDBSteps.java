package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class CheckDBSteps {

    public static void main(String[] args) {

       System.out.println(DBUtils.dbIntoListMap("select * from ohrm_skill"));

    }

    @Then("query HRMS database {string} {string} and {string}")
    public void queryHRMSDatabaseAnd(String firstName, String middleName, String lastName) {

        List<Map<String, String>> resultMap = DBUtils.dbIntoListMap("SELECT emp_firstname, emp_middle_name, emp_lastname "
                + "FROM hs_hr_employees "
                + "WHERE emp_lastname = '" + lastName + "'");


        System.out.println(resultMap);
        Assert.assertEquals(resultMap.get(0).get("emp_firstname") , firstName);
        Assert.assertEquals(resultMap.get(0).get("emp_middle_name") , middleName);

        Assert.assertEquals(resultMap.get(0).get(resultMap.get(0).keySet().toArray()[1]) , middleName);
        Assert.assertEquals(resultMap.get(0).get("emp_lastname") , lastName);

    }

}