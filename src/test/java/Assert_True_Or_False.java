import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assert_True_Or_False {
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
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(4);
        System.out.println(driver.findElement(By.xpath("//h3[text()='I choose you Pikachu !']")).getText());
        Assert.assertTrue("Pikachu not found!" , driver.findElement(By.xpath("//h3[text()='I choose you Pikachu !']"))
                .getText().contains("PikachuXXX"));
        Assert.assertFalse(driver.findElement(By.xpath("//h3[text()='I choose you Pikachu !']"))
                .getText().contains("HUHU"));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
