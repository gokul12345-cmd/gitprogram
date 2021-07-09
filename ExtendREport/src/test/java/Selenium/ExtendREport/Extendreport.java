package Selenium.ExtendREport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extendreport{
	ExtentReports Extent;

	@BeforeTest
	public  void config() {
		//ExtentReports,ExtentSpartReporter
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Results");
	
		 Extent = new ExtentReports();
		Extent.attachReporter(reporter);
		Extent.setSystemInfo("Tester", "Gokul Bhujbal");
	}
	@Test
	public void demo() {
		ExtentTest test =Extent.createTest("demo");//creating test object tp call method of screenshot
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		test.addScreenCaptureFromBase64String("facebook");//taking Screenshot on test report
	//	test.fail("Result do not match");/// this method will be fail the testresult.
		Extent.flush();//this method to stop execution next step .
	}
}
