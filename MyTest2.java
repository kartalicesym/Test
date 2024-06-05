import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyTest2 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01(){
        //iphone arama sonucu toplam ürün sayısının yazıldığı elemtin varlığının kontrolü
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.className("V8wbcUhU")).sendKeys("iphone"+ Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement resultWE = driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[1]/div"));
        Assert.assertTrue(resultWE.isDisplayed());
    }

    @Test
    public void test02(){
        //Sepete ürün eklenmiş mi kontrolü

        driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[1]/a/div[1]/div[2]/div[2]")).click();//ürüne tıklanıyor

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));//yeni sekmede açıldığı için

        driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[5]/button")).click();//ürünü sepete ekliyor

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int countProductBasket = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[2]/a/div[2]")).getText()) ;

        Assert.assertEquals(countProductBasket, 1);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
