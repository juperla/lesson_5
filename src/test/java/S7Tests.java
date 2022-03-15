import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class S7Tests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void s7WithoutWaitTest() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("author"));
        nameInput.sendKeys("Name");

        Assertions.assertEquals("Name", nameInput.getAttribute("value"));
    }

    @Test
    public void s7ExplicitWaitTest() throws InterruptedException {
     //   WebDriverWait wait = new WebDriverWait(driver, 10, 500);
    //    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".comments-block-wrapper”)));

      //  WebElement nameInput = driver.findElement(By.id("author"));
     //   nameInput.sendKeys("Name");

     //   Assertions.assertEquals("Name", nameInput.getAttribute("value"));
    }


    @AfterEach
    public void tearDown() { driver.quit();}

}
