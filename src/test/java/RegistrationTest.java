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
        driver.get(BASE_URL);
    }

    @Test
    public void test(){
        registrationFill("jozkorozko@gmail.com","Jozko","Rozko","P@ssword123","P@ssword123");
        driver.findElement(By.xpath("//input[@id='checkbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    private void registrationFill(String email, String name, String surname, String password, String passwordAgain) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(surname);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='password-repeat']")).sendKeys(passwordAgain);
    }
}



