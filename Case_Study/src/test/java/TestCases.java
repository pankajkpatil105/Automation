import Pages.CommonFunctions;
import Pages.GoogleMapHomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCases {

    WebDriver driver;
    GoogleMapHomePage googlemaphomepage;
    CommonFunctions commonfuction = new CommonFunctions();

    @Test() public void Google_Direction() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/maps");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        googlemaphomepage = new GoogleMapHomePage(driver);
        googlemaphomepage.Click_Directions();
        Thread.sleep(2000);
        googlemaphomepage.Starting_Location("Jalgaon");
        Thread.sleep(1000);
        googlemaphomepage.Destination_Location("91 Springboard, Vikhroli");
        driver.findElement(By.xpath("//h1[@id='section-directions-trip-title-0']"));
        googlemaphomepage.Select_Route_Print();
        Thread.sleep(3000);
        commonfuction.ScreenShot(driver,"C:\\Users\\panka\\Automation Testing\\Case_Study\\target\\Screenshot"+".png");
        driver.quit();
    }


}
