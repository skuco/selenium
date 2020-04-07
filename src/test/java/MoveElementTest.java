import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveElementTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/moveme.php");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));
        actions.dragAndDrop(donald , tree).build().perform();
        System.out.println("Message: " + driver.findElement(By.xpath("//div[contains(@class,'success')]"))
                .getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'success text-center')]"))
                .isDisplayed());
        Assert.assertEquals("HOOO HOOOOO !!!!" , driver
                .findElement(By.xpath("//div[contains(@class,'success')]"))
                .getText());
    }
}
