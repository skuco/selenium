import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RedAlertTest_AlertWindowsOptions {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test() {
        driver.findElement(By.id("alert1")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        Assert.assertEquals("Kirov Reporting" , driver.findElement(By.xpath("//h1")).getText());

        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        Assert.assertEquals("Negative" , driver.findElement(By.xpath("//h1")).getText());

        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Michal");
        alert3.accept();
        Assert.assertEquals("Waiting for your commands Michal" , driver.findElement(By.xpath("//h1")).getText());
    }

    @After
    public void tearDown(){
    }

}
