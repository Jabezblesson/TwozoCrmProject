package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotUtils {

    public static String takeScreenShot(final WebDriver driver, final String testName) {

        try {
            final String timestamp = String.valueOf(System.currentTimeMillis());
            final File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            final String path = "screenshots/" + testName + "_" + timestamp + ".png";
            FileUtils.copyFile(src, new File(path));

            return path;
        }
        catch (Exception e) {
            System.out.println("⚠ Screenshot skipped: Browser not reachable");
            return null;
        }
    }
}