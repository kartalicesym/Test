package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStepDefinations {
    WebDriver driver;

    @Given("Google sayfasina git")
    public void google_sayfasina_git() {
        System.out.println("given");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

    }
    @When("Arama kismina Burc Yorumu yaz ve arama yap")
    public void arama_kismina_burc_yorumu_yaz_ve_arama_yap() {
        System.out.println("when");
        driver.findElement(By.id("APjFqb")).sendKeys("Burc Yorumu"+ Keys.ENTER);
    }
    @Then("Donen yaniti kontrol et")
    public void donen_yaniti_kontrol_et() {
        System.out.println("then");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("Burc+Yorumu"));
        driver.quit();
    }

}
