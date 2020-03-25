import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jozkorozko@gmail.com");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Jozko");
        driver.findElement(By.xpath("//input[@name='surname']")).sendKeys("Rozko");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword123");
        driver.findElement(By.xpath("//input[@name='password-repeat']")).sendKeys("P@ssword123");
        driver.findElement(By.xpath("//input[@id='checkbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).click();
    }

    @After
    public void tearDown(){

    }

}
