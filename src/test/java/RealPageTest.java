import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RealPageTest {
    private WebDriver driver;
    private final String BASE_URL = "https://www.events4me.eu/register.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//h2//a[@href='nli/event_selection.php']")).click();
    }



}
