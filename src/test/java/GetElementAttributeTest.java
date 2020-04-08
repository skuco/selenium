import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

public class GetElementAttributeTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

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
    public void checkAllActiveSubPages() {

        // Basic test scenario for one bread scrum page
        driver.findElement(By.xpath("//li[a/@href=\"tabulka.php\"]")).click();
        System.out.println(driver.findElement(By.xpath("//li[a/@href=\"tabulka.php\"]")).getAttribute("class"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href=\"tabulka.php\"]"))
                .getAttribute("class").contains("active"));
    }

    @Test
    public void checkAllActiveSubPagesDRY() {

            // Iteration for all pages, optimized according to DRY principle
            String expectedClass = "active";
            List<String> pages = Arrays.asList("clickmebaby.php", "vybersi.php", "tabulka.php", "redalert.php");

            for (String page : pages) {
                driver.get(BASE_URL + "/" + page);
                Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + "']"))
                        .getAttribute("class").contains(expectedClass));
                System.out.println("Checked page: " + page);
            }
    }
}
