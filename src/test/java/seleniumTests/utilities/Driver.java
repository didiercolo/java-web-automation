package seleniumTests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * This handle the way the driver is created based on the OS
 */
public class Driver {

    /**
     * Returns Webdriver instance based on the OS where it is being executed
     *
     * @return Webdriver based on the OS
     */
    public static WebDriver getChromeDriver() {

        /** Set the utilities folder */
        String driversPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

        /** If the tests are executed in MAC OS returns Mac driver */
        if (System.getProperty("os.name").toLowerCase().contains("mac"))
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver");

        /** If the tests are executed in Windows OS returns Mac driver */
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");

        // Note: Not other OS where included in this code.

        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
