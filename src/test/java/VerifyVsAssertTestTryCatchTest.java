import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class VerifyVsAssertTestTryCatchTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";
    private StringBuffer verificationErrors = new StringBuffer(); // buffer contains all errors

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get( BASE_URL + "/tabulka.php");
    }

    private void fail(String verificationErrorString) {
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals("1", driver.findElement(By.cssSelector("td")).getText());
        System.out.println("First Assert Check is DONE.");

        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr")); // creates list of elements

        for (int i = 1; i < rows.size()+1 ; i++) {
            try{
                Assert.assertEquals(String.valueOf(i), driver.findElement(By.xpath("//tr[" + i + "]/td")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString(); // new variable to fill with error messages

        if (!"".equals(verificationErrorString)) { // if some error will occur, then fail the test and print it
            fail(verificationErrorString);
            System.out.println(verificationErrorString);
        }
    }
}
