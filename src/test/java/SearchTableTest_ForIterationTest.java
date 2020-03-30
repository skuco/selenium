import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTableTest_ForIterationTest {
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
        int rows = Integer.parseInt(driver.findElement(By.xpath
                ("/html/body/div/div/table/tbody/tr[last()]/td[1]")).getText());
        System.out.println(rows);
        // printOut all from table
        for (int i = 1; i < rows + 1; i++) {
            System.out.println(driver.findElement(By.xpath
                    ("/html/body/div/div/table/tbody/tr[" + i + "]")).getText());
        }
        // printOut only surnames and check that none of the values are empty
        for (int i = 1; i < rows + 1; i++) {
            System.out.println(driver.findElement(By.xpath
                    ("/html/body/div/div/table/tbody/tr[" + i + "]/td[3]")).getText());
            Assert.assertFalse("Empty value found!", driver.findElement
                    (By.xpath("/html/body/div/div/table/tbody/tr[" + i + "]/td[3]")).getText().isEmpty());
        }
    }

    @After
    public void tearDown(){
    }

}
