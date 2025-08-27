package Chapter7;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReports {
    public static void main(String[] args) {
        //Instantiate ExtentReports object
        //Report document
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter report = new ExtentSparkReporter("src/main/resources/Reports/Spark Report.html");
        //Configure the report
        report.config().setReportName("Test Progress Report");
        report.config().setDocumentTitle("Login Feature Report");

        extent.attachReporter(report);
        //Create tests
        ExtentTest test1 = extent.createTest("TC1 - Test 1", "This is the first test");
        test1.pass("This test has passed");

        ExtentTest test2 = extent.createTest("TC2 - Test 2", "This is the second test");
        test2.fail("This test has failed");

        ExtentTest test3 = extent.createTest("TC3 - Test 3", "This is the third test");
        test3.warning("This test contains a warning");

        ExtentTest test4 = extent.createTest("TC4 - Test 4", "This is the fourth test");
        test4.info("Information");

        ExtentTest test5 = extent.createTest("TC5 - Test 5", "This is the test to be skipped");
        test5.skip("To be skipped");

        Status st = Status.PASS;
        String testDetails = "";
        if (5 >= 6){
            st = Status.PASS;
            testDetails = "Test has passed";
        }else{
            st = Status.FAIL;
            testDetails = "Test failed";
        }

        ExtentTest test6 = extent.createTest("TC6 - Test 6", "Another pass on test 6");
        test6.log(st, testDetails);

        extent.flush();

    }
}
