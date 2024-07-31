import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyTests {

    static WebDriver driver;
    String loginPageURL ="https://practicetestautomation.com/practice-test-login/";

    @BeforeClass
    public static void SetUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("BeforeClass");
    }

    @Test
    public void case1PositiveLoginTest(){
        System.out.println("case1PositiveLoginTest");
        driver.get(loginPageURL);
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
//        System.out.println(driver.getCurrentUrl());
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        if (driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/")){
            if (driver.findElement(By.xpath("//h1[text()=\"Logged In Successfully\"]")).getText().equals("Logged In Successfully")){
//                System.out.println("Logged In Successfully");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.findElement(By.xpath("//a[@href=\"https://practicetestautomation.com/practice-test-login/\"]")).click();
                System.out.println("Test passed");
            }else {
                System.out.println("Login failed");
            }
        }else {
            System.out.println("Did not could go the link");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void case2NegativeLoginTest(){
        System.out.println("case2NegativeLoginTest");
        driver.get(loginPageURL);

        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"error\"]"));


        if (errorElement.isDisplayed()){
            if (errorElement.getText().equals("Your username is invalid!")){
                System.out.println("Test passed");
            }else {
                System.out.println("Test failed; there is not error text");
            }
        }else {
            System.out.println("Test failed ; not displayed error element");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void case3NegativeLoginTest(){
        System.out.println("case3NegativeLoginTest");
        driver.get(loginPageURL);

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
        driver.findElement(By.id("submit")).click();

        WebElement errorElement =driver.findElement(By.id("error"));

        if(errorElement.isDisplayed()){
            if (errorElement.getText().equals("Your password is invalid!")){
                System.out.println("Test passed");
            }else {
                System.out.println("Test failed; not found error text");
            }
        }else {
            System.out.println("Test failed; not found error element");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void TearDown(){
        driver.quit();
        System.out.println("AfterClass");
    }
}
