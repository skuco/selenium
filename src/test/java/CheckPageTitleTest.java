import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class CheckPageTitleTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/index.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() {
        // Create list of all sub-pages - List of elements
        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul//li//a"));

        // From the list of elements above, we created array list of strings
        List<String> pageUrls = new ArrayList<> ();

        // For all elements from List, we added attribute into the array
        for (WebElement page : pages) {
            pageUrls.add(page.getAttribute("href"));
        }

        // Then, for every iteration in array, we can compare strings
        for (String pageUrl :pageUrls) {
            driver.get(pageUrl);

            // This is striping the string according to indexes
            String expectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/")+1, pageUrl.indexOf(".php"));

            // And here, we are comparing strings
            // String expectedTitle from index 0 to 1 (first letter) > to upper case
            // Then, the rest of the string just put together
            //System.out.println(expectedTitle.substring(0,1).toUpperCase() + expectedTitle.substring(1));
            Assert.assertTrue(driver.getTitle()
                    .contains(expectedTitle.substring(0,1).toUpperCase() + expectedTitle.substring(1)));
        }
    }



}
