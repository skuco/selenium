import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverClickHoldTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/semafor.php");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() {

        String expectedRed = "rgb(205, 58, 63)";
        String expectedGreen = "rgb(10, 129, 0)";
        String expectedOrange = "rgb(191, 111, 7)";
        WebElement trafficLight = driver.findElement(By.className("light"));

        // find colors
        String redColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(redColor , expectedRed);

        // Initiate Actions from Selenium
        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLight).build().perform();

        String greenColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen , greenColor);

        actions.clickAndHold(trafficLight).build().perform();
        String orangeColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange , orangeColor);


    }
}
