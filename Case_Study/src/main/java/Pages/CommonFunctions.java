package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class CommonFunctions {
    WebDriver driver;

    public void ScreenShot(WebDriver driver, String fileWithPath) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);;

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);

        FileUtils.copyFile(SrcFile, DestFile);
    }
}