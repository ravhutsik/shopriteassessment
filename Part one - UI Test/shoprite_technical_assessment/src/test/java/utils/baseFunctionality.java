package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class baseFunctionality {

    public static void TakeScreenShots(String TestID){
        String Error;
        try{
            WebDriverWait wait = new WebDriverWait(driverFactory.driver, 10);
            File scrFile = ((TakesScreenshot)driverFactory.driver).getScreenshotAs(OutputType.FILE);
            // copy screenshot to certain location
            FileUtils.copyFile(scrFile, new File("src\\screenshots"+"\\" +TestID+ ".png"));

        }catch(Exception e){
            Error = e.getMessage();
            System.out.println(Error);

        }
    }
}
