import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class CalculatorTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";
    Random objGenerator = new Random();

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/kalkulacka.php");
    }

    @Test
    public void summarizeTest() {
        for (int i = 1; i <= 10 ; i++) {
            int firstNumber = objGenerator.nextInt(1000 + 1000) - 1000;
            String firstInputNumber = Integer.toString(firstNumber);
            driver.findElement(By.id("firstInput")).sendKeys(firstInputNumber);

            int secondNumber = objGenerator.nextInt(1000 + 1000) - 1000;
            String secondInputNumber = Integer.toString(secondNumber);
            driver.findElement(By.id("secondInput")).sendKeys(secondInputNumber);

            driver.findElement(By.id("count")).click();
            String results = driver.findElement(By.id("result")).getText();

            Assert.assertEquals(Integer.toString(firstNumber + secondNumber) , results);
            System.out.println(i + ".) " + firstInputNumber + " + " + secondInputNumber + " = " + results );
            driver.findElement(By.id("reset")).click();
        }
    }

    @Test
    public void deductTest() {
        for (int i = 1; i <= 10 ; i++) {
            int firstNumber = objGenerator.nextInt(1000 + 1000) - 1000;
            String firstInputNumber = Integer.toString(firstNumber);
            driver.findElement(By.id("firstInput")).sendKeys(firstInputNumber);

            int secondNumber = objGenerator.nextInt(1000 + 1000) - 1000;
            String secondInputNumber = Integer.toString(secondNumber);
            driver.findElement(By.id("secondInput")).sendKeys(secondInputNumber);

            driver.findElement(By.id("deduct")).click();
            String results = driver.findElement(By.id("result")).getText();

            Assert.assertEquals(Integer.toString(firstNumber - secondNumber) , results);
            System.out.println(i + ".) " + firstInputNumber + " - " + secondInputNumber + " = " + results );
            driver.findElement(By.id("reset")).click();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
