import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ScreenShotExceptionTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() throws IOException {

        // Current date generation
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss");
        Date date = new Date();
        String simpleDate = dateFormat.format(date);
        String fileName = "screenshot-" + simpleDate + ".png";

        // Capturing screenshot
        File screeShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screeShot, new File(".//screenshots//" + fileName ));

        driver.quit();
    }

    @Test
    public void test() {
        String expectedClass = "active";
        List<String> pages = Arrays.asList("clickmebaby.php", "vybersiXXX.php", "tabulka.php", "redalert.php");

        for (String page : pages) {
            driver.get(BASE_URL + "/" + page);
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + "']"))
                    .getAttribute("class").contains(expectedClass));
            System.out.println("Checked page: " + page);
        }
    }



}
