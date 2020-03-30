import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountTest_DRY_Principle {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {

        // Helping stuff
        driver.findElement(By.id("clicks")).getText();
        System.out.print("Number of clicks: " + driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        driver.navigate().refresh();

        // Assertion playground
        // Wrong not-DRY principle
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
        driver.navigate().refresh();

        // Correct DRY principle
        // Check final count of clicks only at the end
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("clickMe")).click();
        }
        Assert.assertEquals( "10", driver.findElement(By.id("clicks")).getText());
        driver.navigate().refresh();

        // Check every click
        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals( String.valueOf(i), driver.findElement(By.id("clicks")).getText());
        }
        driver.navigate().refresh();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
