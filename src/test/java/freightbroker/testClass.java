package freightbroker;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class testClass {

	 public static ChromeDriver driver;

	    @BeforeTest
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "C://freight broker//java//SeleniumTraining//Driver//chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://staging.d2m5lpbf9n6q29.amplifyapp.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    }

	    @AfterTest
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
