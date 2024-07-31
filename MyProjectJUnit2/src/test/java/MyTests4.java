import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MyTests4 {
    WebDriver driver;
    String baseURL = "https://practicetestautomation.com/practice-test-login/";
    JavascriptExecutor js;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @ParameterizedTest
    @CsvSource({
            "student, Password123"
    })
    public void testLoginPositive(String username, String password) {

        // Web sayfasını yükle
        driver.get(baseURL);

        // Kullanıcı adı ve şifreyi gir
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        // Giriş yap düğmesine tıkla
        driver.findElement(By.id("submit")).click();

        js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Girişin başarılı olduğunu kontrol et
        WebElement actualElement = driver.findElement(By.className("post-title"));
        String actualMessage = driver.findElement(By.className("post-title")).getText();
        String expectedMessage = "Logged In Successfully";

        Assertions.assertEquals(expectedMessage, actualMessage,"Positive Test failed");

    }

    @ParameterizedTest
    @CsvSource({
            "incorrectUser, Password123, username",
            "student, incorrectPassword, password"
    })
    public void testLoginNegative(String username, String password, String falseNameValue) {

        // Web sayfasını yükle
        driver.get(baseURL);

        // Kullanıcı adı ve şifreyi gir
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        // Giriş yap düğmesine tıkla
        driver.findElement(By.id("submit")).click();

        js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Girişin başarılısız olduğunu kontrol et
        String actualMessage = driver.findElement(By.id("error")).getText();

        String expectedMessage = "Your "+falseNameValue+" is invalid!";
        Assertions.assertEquals(expectedMessage, actualMessage, "Negative Test failed");
    }

    @AfterEach
    public void tearDown(){
        // WebDriver'ı kapat
        driver.quit();
    }
}
