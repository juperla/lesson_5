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
        String subjectsInput = "C";
        String currentAddress = "USA";

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
        select1.selectByIndex(1983);

        driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]")).click();


      driver.findElement(By.xpath("//*[@id='subjectsInput']")).click();
      driver.findElement(By.id("subjectsInput")).sendKeys(subjectsInput);
      WebElement selectElement = driver.findElement(By.id("subjectsInput"));
        Select select2 = new Select(selectElement);
        select2.selectByVisibleText("Chemistry");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[2]/label"));
        checkBox.click();

        file = new File("src/image.png.jpg");
        WebElement selectPictureButton = driver.findElement(By.id("uploadPicture"));
        selectPictureButton.sendKeys(file.getAbsolutePath());

        driver.findElement(By.xpath("//*[@id='currentAddress']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

        WebElement selectElement1 = driver.findElement(By.xpath("//*[@id='state']"));
        Select select1 = new Select(selectElement1);
        select1.selectByVisibleText("Haryana");

        WebElement selectElement2 = driver.findElement(By.xpath("//*[@id='city']"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("Karnal");


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
