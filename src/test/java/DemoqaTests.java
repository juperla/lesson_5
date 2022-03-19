import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class DemoqaTests {

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

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void authenticationDemoqaTest() throws InterruptedException {
        String firstName = "Юлия";
        String lastName = "Super";
        String userEmail = "email@yahoo.com";
        String userNumber = "9139111111";


        driver.findElement(By.xpath("//*[@id='firstName']")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='lastName']")).click();
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id='userEmail']")).click();
        driver.findElement(By.id("userEmail")).sendKeys(userEmail);

        WebElement testingRadioButton = driver.findElement(By.xpath("//*[text()='Female']"));
        testingRadioButton.click();

        driver.findElement(By.xpath("//*[@id='userNumber']")).click();
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);

        driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();

        WebElement elementDropdown = driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select select = new Select(elementDropdown);
        select.selectByIndex(3);

        WebElement elementDropdown1 = driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select select1 = new Select(elementDropdown1);
        select1.selectByVisibleText("1983");

        driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]")).click();

        WebElement subjectsAutocomplete = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectsAutocomplete);
        subjectsAutocomplete.sendKeys("Chemistry");
        subjectsAutocomplete.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[2]/label")).click();

        File file = new File("src/image.png.jpg");
        WebElement selectPictureButton = driver.findElement(By.id("uploadPicture"));
        selectPictureButton.sendKeys(file.getAbsolutePath());

        WebElement subjectsAutocomplete1 = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectsAutocomplete);
        subjectsAutocomplete1.sendKeys("Russia, Novosibirsk");
        subjectsAutocomplete1.sendKeys(Keys.ESCAPE);

        // driver.findElement(By.id("currentAddress")).sendKeys("Russia");

        WebElement selectElement3 = driver.findElement(By.xpath("//*[@id='state']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectElement3);
        Select select3 = new Select(selectElement3);
        select3.selectByIndex(3);

        WebElement selectElement4 = driver.findElement(By.id("city"));
        Select select4 = new Select(selectElement4);
        select4.selectByVisibleText("Karnal");

        driver.findElement(By.id("submit")).click();


        //  Assertions.assertEquals("Haryana", allOption.get(3).getText());


        // WebElement succecfullLoginMessageLabel = driver.findElement(By.id("flash"));
        //  String succecfullLoginMessage = succecfullLoginMessageLabel.getText();

        //  Thread.sleep(3000);
        // Assertions.assertTrue(succecfullLoginMessageLabel.isDisplayed());
        // Assertions.assertTrue(succecfullLoginMessage.contains("You logged into a secure area!"));
        //   Assertions.assertEquals("true", testingRadioButton.getAttribute("checked"));
        //   Assertions.assertFalse(programmingRadioButton.isSelected());

        //  driver.findElement(By.id("flash")).isDisplayed();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
