package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class GoogleMapHomePage {

    WebDriver driver;
    By Directions = By.xpath("//button[@aria-label='Directions']");
    By StartingLocation = By.xpath("//input[@tooltip='Choose starting point, or click on the map...']");
    By DestinationLocation= By.xpath("//div[@id='sb_ifc52']//input");

    By SelectFirstRoute = By.xpath("//h1[@id='section-directions-trip-title-0']");

    public GoogleMapHomePage(WebDriver driver){
        this.driver=driver;
    }

    public void Click_Directions() {
        driver.findElement(Directions).click();
    }

    public void Starting_Location(String S1) {
        driver.findElement(StartingLocation).sendKeys(S1);
    }
    public void Destination_Location(String S2) throws InterruptedException {
        driver.findElement(DestinationLocation).sendKeys(S2);
        driver.findElement(DestinationLocation).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@aria-label='Driving']/parent::button")).click();
        Thread.sleep(5000);
    }

    public void Select_Route_Print() throws InterruptedException {
        By PrintButton = By.xpath("//button[@aria-label=' Print ']");
        By PrintTextButton = By.xpath("//button[text()=' Print text only ']");
        driver.findElement(SelectFirstRoute).click();
        Thread.sleep(2000);
        driver.findElement(PrintButton).click();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(PrintTextButton)).click(driver.findElement(PrintTextButton)).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()=' Cancel ']")).click();
    }


}


