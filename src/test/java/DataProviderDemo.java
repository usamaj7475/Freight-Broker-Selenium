package testng_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	
	
	
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

    @Test (dataProvider = "getTestData")
    public void assertlogin(String uname, String pwd) {
    	
    	System.out.println("Username: " + uname);
    	System.out.println("Password: " + pwd);
        driver.findElement(By.id("basic_email")).sendKeys(uname);
        driver.findElement(By.id("basic_password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-message-notice-content']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'all reviews')]")).isDisplayed());

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://staging.d2m5lpbf9n6q29.amplifyapp.com/all-reviews";
        Assert.assertEquals(actualUrl, expectedUrl);
        
        driver.findElement(By.xpath("//p[@class='text-black']")).click();
    }


@DataProvider
public Object [][] getTestData(){
	
	Object[][]data =  new Object[2][2];
	
	data[0][0] ="usama.javed+broker101@emerald-labs.com";
	data[0][1] ="asdasdasd";
	data[1][0] ="usama.javed+brokertd@emerald-labs.com";
	data[1][1] ="asdasdasd";
	return data;
}

}

