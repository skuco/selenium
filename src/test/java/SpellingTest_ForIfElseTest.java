import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SpellingTest_ForIfElseTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test(){
        // Initial Check
        Assert.assertEquals("0" , driver.findElement(By
                .xpath("//h1[@id='clicks']")).getText());
        Assert.assertEquals("klikov" , driver.findElement(By
                .xpath("//p[@class='description']")).getText());
        // Spelling Check
        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            System.out.println(driver.findElement(By.xpath("//p[@class='description']")).getText());
            if (i==1){
                Assert.assertEquals("klik" , driver.findElement(By
                        .xpath("//p[@class='description']")).getText());
            }
            if (i>=2 && i<=4){
                Assert.assertEquals("kliky" , driver.findElement(By
                        .xpath("//p[@class='description']")).getText());
            }
            if (i>=5){
                Assert.assertEquals("klikov" , driver.findElement(By
                        .xpath("//p[@class='description']")).getText());
            }
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
