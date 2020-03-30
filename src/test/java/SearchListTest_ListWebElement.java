import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SearchListTest_ListWebElement {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows);
        for (WebElement row : rows) {
            System.out.println(row.findElement(By.xpath("./td[4]")).getText());
            Assert.assertFalse(row.findElement(By.xpath("./td[4]")).getText().isEmpty());
        }
    }

    @After
    public void tearDown(){
    }

}
