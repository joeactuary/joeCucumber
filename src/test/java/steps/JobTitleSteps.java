package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AdminPage;
import pages.DashboardPage;
import utils.CommonMethods2;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobTitleSteps extends CommonMethods2 {

    @When("user looks at all job titles")
    public void userLooksAtAllJobTitles() {

        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.adminButton);
        AdminPage adminPage = new AdminPage();
        click(adminPage.jobButton);
        click(adminPage.jobTitlesButton);
        List<WebElement> jobTitleList = new ArrayList<>();
        jobTitleList = adminPage.jobTitleList;

        List<Map<String, String>> resultMap = DBUtils.dbIntoListMap("select * FROM ohrm_job_title where is_deleted = 0 order by job_title;");
        System.out.println("List SIZE is: " + jobTitleList.size());
        System.out.println("DB size is " + resultMap.size());

        Assert.assertEquals(jobTitleList.size() , resultMap.size());

        for (int i=0 ; i <jobTitleList.size() ; i++ ) {
            System.out.println(jobTitleList.get(i).getText() + "     " + resultMap.get(i).get("job_title"));
            Assert.assertEquals(jobTitleList.get(i).getText() , resultMap.get(i).get("job_title"));

        }

    }

    @When("verify job titles are matched in ui and d")
    public void verify_job_titles_are_matched_in_ui_and_d() {
      /*  List<Map<String, String>> resultMap = DBUtils.dbIntoListMap("select * FROM ohrm_job_title where is_deleted = 0;");
        System.out.println("DB size is " + resultMap.size());
        for (int i=0 ; i <resultMap.size() ; i++ ) {
            System.out.println(resultMap.get(i).get("job_title"));


        }*/
    }



}
