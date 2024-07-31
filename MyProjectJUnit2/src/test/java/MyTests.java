import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyTests {

    WebDriver driver;

    @Before
    public void setUpTest(){
//        System.out.println("setUpTest");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Ignore("Test ignored for a short time.")
    @Test
    public void testAssertion1(){
        System.out.println("testAssertion1");

        driver.get("https://www.google.com");
        String expectedData = "Google";
        String actualData = driver.getTitle();

        Assert.assertEquals(expectedData, actualData);

    }


    @Test(timeout = 2000)
    public void testAssertion2(){
        System.out.println("testAssertion2");

        driver.get("https://www.facebook.com");
        String expectedData = "Facebook";
        String actualData = driver.getTitle();

        Assert.assertTrue(actualData.contains(expectedData));
    }

    @After
    public void tearDown(){
//        System.out.println("tearDown");
        driver.quit();
    }

}
