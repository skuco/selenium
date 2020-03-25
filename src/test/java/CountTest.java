import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test() {

        // Helping stuff
        System.out.print("Number of clicks: " + driver.findElement(By.id("clicks")).getText());
        //driver.findElement(By.id("clicks")).getText();
        //driver.findElement(By.id("clickMe")).click();

        // Assertion playground
        Assert.assertEquals( "0", driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals( "1", driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals( "2", driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals( "3", driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals( "4", driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals( "5", driver.findElement(By.id("clicks")).getText());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
