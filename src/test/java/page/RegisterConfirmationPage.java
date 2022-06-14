package page;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class RegisterConfirmationPage {
    public RegisterConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
