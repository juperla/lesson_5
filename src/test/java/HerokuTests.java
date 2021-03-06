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

public class HerokuTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void checkCurrentUrl() throws InterruptedException {
        Assertions.assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Test
    public void checkTitle() {
        Assertions.assertEquals("The Internet", driver.getTitle());
    }

    public void tearDown() {
        driver.quit();
    }

    @Test
    public void authenticationTest() throws InterruptedException {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("radius")).click();

        WebElement succecfullLoginMessageLabel = driver.findElement(By.id("flash"));
        String succecfullLoginMessage = succecfullLoginMessageLabel.getText();

        Thread.sleep(3000);
        Assertions.assertTrue(succecfullLoginMessageLabel.isDisplayed());
        Assertions.assertTrue(succecfullLoginMessage.contains("You logged into a secure area!"));

        driver.findElement(By.id("flash")).isDisplayed();

        System.out.println("Locatoin x = " + succecfullLoginMessageLabel.getLocation().getX() + ", " + "y = " + succecfullLoginMessageLabel.getLocation().getY());

    }


}
