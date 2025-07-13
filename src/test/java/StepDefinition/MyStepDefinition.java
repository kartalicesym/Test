package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.MyDriver;

public class MyStepDefinition {
    private static WebDriver driver;

    @Given("go to link")
    public void go_to_link() {
        driver = MyDriver.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //System.out.println("linke gidildi");
    }
    @And("type username {string}")
    public void typeUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
        //System.out.println("kullanici adi girildi");

    }
    @And("type password {string}")
    public void typePassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        //System.out.println("sifre girildi");
    }
    @When("click on the submit button")
    public void click_on_the_submit_button() {
        driver.findElement(By.id("submit")).click();
        //System.out.println("butona tiklandi");
    }
    @Then("check the link")
    public void check_the_link() {
        //System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("https://practicetestautomation.com/logged-in-successfully/", driver.getCurrentUrl());
        //System.out.println("link kontrol edildi");
    }
    @And("check the expected message{string}")
    public void checkTheExpectedMessage(String message) {
        Assert.assertEquals(message,driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1")).getText());
    }
    @Then("check the error message {string}")
    public void checkTheErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"error\"]"));

        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorMessage, errorElement.getText());
    }
}
