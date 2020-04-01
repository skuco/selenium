import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

import java.util.List;

public class CSS_ElementCheckTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL + "/stroopeffect.php");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() {

        // create list of all available colors of h1 elements
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]//h1"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
        }

        // check color of first h1 element, convert to hex and check if it match
        String rgba = driver.findElement(By.xpath("//div[contains(@class,'colours')]//h1[1]"))
                .getCssValue("color");
        String hexColor = Color.fromString(rgba).asHex();
        Assert.assertEquals("#ff0e0e", hexColor);
        System.out.println("Color " + hexColor + " matches the one on the page.");
    }



}
