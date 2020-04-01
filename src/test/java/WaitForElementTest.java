import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/zjavenie.php");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        // set static sleep value (very bad idea!)
        driver.findElement(By.xpath("//button[@id='showHim']")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div//img[@class='brano']"));
        driver.navigate().refresh();

        // set dynamic sleep / wait
        driver.findElement(By.xpath("//button[@id='showHim']")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div//img[@class='brano']")));
        driver.findElement(By.xpath("//div//img[@class='brano']")).isDisplayed();
    }



}
