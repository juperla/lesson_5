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
import org.openqa.selenium.support.ui.Select;

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
      //  String dateOfBirthInput = "14 Mar 2022";
        String subjectsContainer = "Culture";
        String currentAddress = "Russia";
        String elementDropdown = null;

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).click();
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).click();
        driver.findElement(By.id("userEmail")).sendKeys(userEmail);

        WebElement testingRadioButton = driver.findElement(By.xpath("//label[text()='Female']"));
        WebElement programmingRadioButton = driver.findElement(By.xpath("//label[text()='Female']"));
        testingRadioButton.click();

        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).click();
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);

     //   driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).click();
     //   driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).clear();
     //   driver.findElement(By.id("dateOfBirthInput")).sendKeys(dateOfBirthInput);

        driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]")).click();
        driver.findElement(By.id("subjectsContainer")).sendKeys(subjectsContainer);

        WebElement testingCheckBox = driver.findElement(By.xpath("//label[text()='Reading']"));
        WebElement readingCheckBox = driver.findElement(By.xpath("//label[text()='Reading']"));
        testingCheckBox.click();

       driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]")).click();
      // driver.findElement(By.id("uploadPicture")).;

        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).click();
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

        driver.findElement(By.xpath("//*[@id=\"state\"]")).click();
        Select select = new Select(elementDropdown);
        select.selectByIndex(3);

        driver.findElement(By.xpath("//*[@id=\"city\"]")).click();
        select.selectByIndex(1);

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

    // @AfterEach
    //  public void tearDown() {
    //      driver.quit();}

}
