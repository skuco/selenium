import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AAA_CleanTemplate {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/clickmebaby.php");
    }

    @After
    public void tearDown(){
    }

    @Test
    public void test() {
    }



}
