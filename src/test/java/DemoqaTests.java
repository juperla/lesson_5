import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;

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

        driver.findElement(By.id("currentAddress")).sendKeys("Russia, Novosibirsk");

        driver.findElement(By.id("state")).click();
        driver.switchTo().activeElement().sendKeys("NCR");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        driver.findElement(By.id("city")).click();
        driver.switchTo().activeElement().sendKeys("Delhi");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);


        WebElement button = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(3000);

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(driver.findElement(By.id("example-modal-sizes-title-lg")).getText()).isEqualTo("Thanks for submitting the form");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='Юлия Super']")).getText()).isEqualTo("Юлия Super");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='email@yahoo.com']")).getText()).isEqualTo("email@yahoo.com");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='Female']")).getText()).isEqualTo("Female");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='9139111111']")).getText()).isEqualTo("9139111111");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='17 March 1983']")).getText()).isEqualTo("17 March 1983");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='Chemistry']")).getText()).isEqualTo("Chemistry");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='Reading']")).getText()).isEqualTo("Reading");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='src/image.png.jpg']")).getText()).isEqualTo("src/image.png.jpg");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='Russia, Novosibirsk']")).getText()).isEqualTo("Russia, Novosibirsk");
        softAssert.assertThat(driver.findElement(By.xpath("//td[text()='NCR Delhi']")).getText()).isEqualTo("NCR Delhi");

        softAssert.assertAll();
    }

      @AfterEach
      public void tearDown() {driver.quit();}

}
