import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/vybersi.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test() {
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(3);
        new Select(driver.findElement(By.className("form-control"))).selectByValue("04");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
